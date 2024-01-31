package tsbe.multiversal.systems.states;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.common.IObserver;
import tsbe.multiversal.systems.*;
import tsbe.multiversal.systems.commands.CMD_DeathRevive;
import tsbe.multiversal.systems.commands.CMD_Help;
import tsbe.multiversal.systems.commands.CMD_LeaveGame;
import tsbe.multiversal.systems.commands.CMD_OpenInventory;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.systems.*;

import java.util.Arrays;
import java.util.List;

public class GS_DeathScreen implements IGameState {

    public List<ICommand> available_commands = Arrays.asList(new CMD_OpenInventory(), new CMD_DeathRevive(), new CMD_LeaveGame(), new CMD_Help(this));

    @Override
    public void onStateStart() {
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + GlobalUIM.getInstance().centeredText("", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        for(int i = 0; i < 8; i++){
            if(i == 3) System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().centeredText("%sVous êtes malheureusement mort !%s".formatted(Constants.SCOLOR_RED, Constants.SCOLOR_WHITE), 78, " ", 10) + "│" + Constants.SCOLOR_RESET);
            else if(i == 5) System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().centeredText("Revivre vous fera perdre des objets et de l'argent", 78, " ", 0) + "│" + Constants.SCOLOR_RESET);
            else System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().centeredText("", 78, " ", 0) + "│" + Constants.SCOLOR_RESET);
        }
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);
    }

    @Override
    public void onStateResume() {
        onStateStart();
        String[] argv = new String[]{};
        boolean valid = false;
        ICommand curr_cmd = null;
        while(!valid) {
            argv = GlobalUIM.getInstance().askInlineInput(Constants.ASK_NEXT_MOVE).trim().replaceAll(" +", " ").split(" +");
            for(ICommand c : available_commands)
                if(argv[0].equals(c.getPrefix()) && argv.length == c.getArgs()+1 && c.valid(argv, null)) { valid = true; curr_cmd = c; }
        }

        curr_cmd.execute(argv, null);

    }

    @Override
    public void onPlayerCreated() {}

    @Override
    public void onEnterDungeon(Dungeon dungeon) {}

    @Override
    public void onExitDungeon() {}

    @Override
    public void onPlayerDeath() {}

    @Override
    public void onPlayerFinalDeath() {
        // Exists the program.
    }

    @Override
    public void onPlayerRevive() {
        GlobalGameManager.getInstance().player.notify(IObserver.NotificationType.PLAYER_REVIVE);
        GameStateManager.getInstance().changeState(new GS_MainMenu());
    }

    @Override
    public void onInventoryOpen() {
        GameStateManager.getInstance().changeState(new GS_Inventory(this));
    }

    @Override
    public void onInventoryClose() {}

    @Override
    public List<ICommand> getAvailableCommands() {
        return available_commands;
    }
}
