package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

import java.util.List;

public class CMD_SpellList implements ICommand {
    @Override
    public String getPrefix() {
        return "sl";
    }

    @Override
    public int getArgs() {
        return 0;
    }

    @Override
    public boolean valid(String[] argv, Object[] data) {
        return true;
    }

    @Override
    public boolean execute(String[] argv, Object[] data) {
        List<IAbility> abilities = GlobalGameManager.getInstance().player.getAbilities();
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + GlobalUIM.getInstance().centeredText(" Compétences & Sorts ", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        for(IAbility a : abilities){
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" [%s%s%s] %s%s%s %s%s%s".formatted(Constants.SCOLOR_CYAN, a.getIdentifier(), Constants.SCOLOR_WHITE, Constants.SCOLOR_YELLOW, a.getName(), Constants.SCOLOR_WHITE, Constants.SCOLOR_RESET+Constants.SCOLOR_WHITE, a.getDescription(), Constants.SCOLOR_BRIGHT), 78, " ", 33) + Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT+ "│");
        }
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);
        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sListe des compétences et sorts :%s sl %s%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);
    }
}
