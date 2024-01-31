package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;
import tsbe.multiversal.systems.IGameState;
import tsbe.multiversal.systems.states.GS_MainMenu;

import java.util.List;

public class CMD_Help implements ICommand {

    IGameState parentstate;

    public CMD_Help(IGameState state){
        parentstate = state;
    }

    @Override
    public String getPrefix() {
        return "help";
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
        List<ICommand> cmdlist = parentstate.getAvailableCommands();
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + GlobalUIM.getInstance().centeredText("", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        for(ICommand c : cmdlist){
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + c.getHelpDesc() + Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT+ "│");
        }
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);
        if(parentstate instanceof GS_MainMenu) ((GS_MainMenu)parentstate).next_no_display = true;
        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sAide :%s help %s%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);
    }
}
