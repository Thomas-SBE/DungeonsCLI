package tsbe.multiversal.systems.states;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.*;
import tsbe.multiversal.systems.commands.CMD_DungeonEnter;
import tsbe.multiversal.systems.commands.CMD_Help;
import tsbe.multiversal.systems.commands.CMD_LeaveGame;
import tsbe.multiversal.systems.commands.CMD_OpenInventory;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.systems.*;

import java.util.Arrays;
import java.util.List;

public class GS_MainMenu implements IGameState {

    public List<ICommand> available_commands = Arrays.asList(new CMD_OpenInventory(), new CMD_DungeonEnter(), new CMD_Help(this), new CMD_LeaveGame());


    @Override
    public void onStateStart() {
        onStateResume();
    }

    public boolean next_no_display = false;

    @Override
    public void onStateResume() {
        if(!next_no_display) GlobalUIM.getInstance().displayMainMenu(GlobalGameManager.getInstance().availableDungeons);
        next_no_display = false;
        String[] argv = new String[]{};
        boolean valid = false;
        ICommand curr_cmd = null;
        while(!valid) {
            argv = GlobalUIM.getInstance().askInlineInput(Constants.ASK_NEXT_MOVE).trim().replaceAll(" +", " ").split(" +");
            for(ICommand c : available_commands)
                if(argv[0].equals(c.getPrefix()) && argv.length == c.getArgs()+1 && c.valid(argv, null)) { valid = true; curr_cmd = c; }
        }

        curr_cmd.execute(argv, null);

        GameStateManager.getInstance().resumeState();
    }

    @Override
    public void onPlayerCreated() {}

    @Override
    public void onEnterDungeon(Dungeon dungeon) {
        GameStateManager.getInstance().changeState(new GS_Dungeon(dungeon, 0));
    }

    @Override
    public void onExitDungeon() {}

    @Override
    public void onPlayerDeath() {
        GameStateManager.getInstance().changeState(new GS_DeathScreen());
    }

    @Override
    public void onPlayerFinalDeath() {}

    @Override
    public void onPlayerRevive() {}

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
