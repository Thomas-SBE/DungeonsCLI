package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.GameStateManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

public class CMD_DeathRevive implements ICommand {
    @Override
    public String getPrefix() {
        return "revive";
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
        GameStateManager.getInstance().revivePlayer();
        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sRéssuciter :%s revive %s%sNécessite une pomme d'or.".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_RESET, Constants.SCOLOR_WHITE), 78, " ", 19);
    }
}
