package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.GameStateManager;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

public class CMD_DungeonEnter implements ICommand {
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
        try {
            int index = Integer.parseInt(argv[1]);
            if(GlobalGameManager.getInstance().availableDungeons.size() <= index) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean execute(String[] argv, Object[] data) {
        int index = Integer.parseInt(argv[1]);
        GameStateManager.getInstance().enterDungeon(GlobalGameManager.getInstance().availableDungeons.get(index));
        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sEntrer dans le donjon :%s d %s<index_du_donjon>%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);
    }
}
