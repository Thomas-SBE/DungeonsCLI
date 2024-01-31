package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.GameStateManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

public class CMD_OpenInventory implements ICommand {
    @Override
    public String getPrefix() {
        return "i";
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
        GameStateManager.getInstance().openInventory();
        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sAccèder / Afficher a l'inventaire :%s i %s%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);
    }
}
