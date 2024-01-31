package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.GameStateManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;

public class CMD_LeaveGame implements ICommand {
    @Override
    public String getPrefix() {
        return "exit";
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
        String response = "";
        while(!(response.equals("n") || response.equals("o") || response.equals("oui") || response.equals("non"))) response = GlobalUIM.getInstance().askInlineInput("Voulez-vous quitter le jeu ?", Constants.SCOLOR_WHITE + " (o/oui ou n/non) +-→ " + Constants.SCOLOR_RESET).trim().toLowerCase().replaceAll(" +", "");
        if(response.equals("n") || response.equals("non")) GameStateManager.getInstance().resumeState();
        else { System.exit(0); }
        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sQuitter le jeu :%s exit %s%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);
    }
}
