package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.items.baseclasses.EquipmentItem;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

public class CMD_InventoryUnequip implements ICommand {
    @Override
    public String getPrefix() {
        return "d";
    }

    @Override
    public int getArgs() {
        return 1;
    }

    @Override
    public boolean valid(String[] argv, Object[] data) {
        return argv[1].equals("H") || argv[1].equals("A") || argv[1].equals("T") || argv[1].equals("L") || argv[1].equals("S");
    }

    @Override
    public boolean execute(String[] argv, Object[] data) {
        String item = null;
        switch (argv[1]){
            case "H" -> item = GlobalGameManager.getInstance().player.unequip(EquipmentItem.EquipmentType.HELMET);
            case "A" -> item = GlobalGameManager.getInstance().player.unequip(EquipmentItem.EquipmentType.ATTACK);
            case "T" -> item = GlobalGameManager.getInstance().player.unequip(EquipmentItem.EquipmentType.TORSO);
            case "L" -> item = GlobalGameManager.getInstance().player.unequip(EquipmentItem.EquipmentType.LEGS);
            case "S" -> item = GlobalGameManager.getInstance().player.unequip(EquipmentItem.EquipmentType.SHOES);
        }

        if(item == null) return false;

        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + GlobalUIM.getInstance().centeredText("", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" Vous avez déséquipé le/la %s%s%s !".formatted(Constants.SCOLOR_YELLOW, GlobalGameManager.getInstance().getItemFromID(item).getName(), Constants.SCOLOR_WHITE), 78, " ", 10) + "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);

        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sDéséquiper un objet :%s d %s<lettre_du_type_equipement>%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);

    }
}
