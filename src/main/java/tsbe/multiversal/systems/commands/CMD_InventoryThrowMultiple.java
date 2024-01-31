package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

import java.util.ArrayList;
import java.util.List;

public class CMD_InventoryThrowMultiple implements ICommand {
    @Override
    public String getPrefix() {
        return "j";
    }

    @Override
    public int getArgs() {
        return 2;
    }

    @Override
    public boolean valid(String[] argv, Object[] data) {
        try {
            int index = Integer.parseInt(argv[1]);
            int amount = Integer.parseInt(argv[2]);
            if(GlobalGameManager.getInstance().player.getInventory().keySet().size() <= index) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean execute(String[] argv, Object[] data) {
        int index = Integer.parseInt(argv[1]);
        int amount = Integer.parseInt(argv[2]);
        List<String> keys = new ArrayList<>(GlobalGameManager.getInstance().player.getInventory().keySet());
        int number = GlobalGameManager.getInstance().player.getInventory().get(keys.get(index));
        GlobalGameManager.getInstance().player.removeItem(keys.get(index), amount);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + GlobalUIM.getInstance().centeredText("", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" Vous avez jeté %d %s%s%s !".formatted(Math.min(amount, number), Constants.SCOLOR_YELLOW, GlobalGameManager.getInstance().getItemFromID(keys.get(index)).getName(), Constants.SCOLOR_WHITE), 78, " ", 10) + "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);
        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sJeter plusieurs objet :%s j %s<index_objet> <nombre>%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);

    }
}
