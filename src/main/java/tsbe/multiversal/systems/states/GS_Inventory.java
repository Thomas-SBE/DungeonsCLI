package tsbe.multiversal.systems.states;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.*;
import tsbe.multiversal.systems.commands.*;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.systems.*;
import tsbe.multiversal.systems.commands.*;

import java.util.Arrays;
import java.util.List;

public class GS_Inventory implements IGameState {

    private IGameState parent_game_state;

    private List<ICommand> available_commands = Arrays.asList(new CMD_OpenInventory(), new CMD_InventoryUse(), new CMD_InventoryGoBack(), new CMD_InventoryUnequip(), new CMD_Help(this), new CMD_SpellList(), new CMD_InventoryThrow(), new CMD_InventoryThrowMultiple(), new CMD_LeaveGame());

    public GS_Inventory(IGameState parent_state){
        parent_game_state = parent_state;
    }

    @Override
    public void onStateStart() {
        GlobalUIM.getInstance().displayInventory(GlobalGameManager.getInstance().player);
        onStateResume();
    }

    @Override
    public void onStateResume() {
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
    public void onPlayerCreated() {

    }

    @Override
    public void onEnterDungeon(Dungeon dungeon) {

    }

    @Override
    public void onExitDungeon() {

    }

    @Override
    public void onPlayerDeath() {

    }

    @Override
    public void onPlayerFinalDeath() {

    }

    @Override
    public void onPlayerRevive() {

    }

    @Override
    public void onInventoryOpen() {
        GlobalUIM.getInstance().displayInventory(GlobalGameManager.getInstance().player);
    }

    @Override
    public void onInventoryClose() {
        GameStateManager.getInstance().changeState(parent_game_state, false);
        GameStateManager.getInstance().resumeState();
        parent_game_state = null;
    }

    @Override
    public List<ICommand> getAvailableCommands() {
        return available_commands;
    }
}
