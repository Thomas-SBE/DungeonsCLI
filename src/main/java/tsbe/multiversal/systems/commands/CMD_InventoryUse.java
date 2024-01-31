package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.items.baseclasses.EquipmentItem;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

import java.util.ArrayList;
import java.util.List;

public class CMD_InventoryUse implements ICommand {
    @Override
    public String getPrefix() {
        return "u";
    }

    @Override
    public int getArgs() {
        return 1;
    }

    @Override
    public boolean valid(String[] argv, Object[] data) {
        try {
            int index = Integer.parseInt(argv[1]);
            if(GlobalGameManager.getInstance().player.getInventory().keySet().size() <= index) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean execute(String[] argv, Object[] data) {
        int index = Integer.parseInt(argv[1]);
        List<String> keys = new ArrayList<>(GlobalGameManager.getInstance().player.getInventory().keySet());
        GlobalGameManager.getInstance().getItemFromID(keys.get(index)).use(GlobalGameManager.getInstance().player);

        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + GlobalUIM.getInstance().centeredText("", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        if(!(GlobalGameManager.getInstance().getItemFromID(keys.get(index)) instanceof EquipmentItem)){
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" Vous avez utilisé un(e) %s%s%s !".formatted(Constants.SCOLOR_YELLOW, GlobalGameManager.getInstance().getItemFromID(keys.get(index)).getName(), Constants.SCOLOR_WHITE), 78, " ", 10) + "│");
            GlobalGameManager.getInstance().player.removeItem(keys.get(index));
        }
        else{
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" Vous avez équipé le/la %s%s%s !".formatted(Constants.SCOLOR_YELLOW, GlobalGameManager.getInstance().getItemFromID(keys.get(index)).getName(), Constants.SCOLOR_WHITE), 78, " ", 10) + "│");
            GlobalGameManager.getInstance().player.equip((EquipmentItem) GlobalGameManager.getInstance().getItemFromID(keys.get(index)));
        }
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);

        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sUtiliser / Equiper objet :%s u %s<index_objet>%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);

    }
}
