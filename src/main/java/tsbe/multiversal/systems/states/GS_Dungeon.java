package tsbe.multiversal.systems.states;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.systems.*;
import tsbe.multiversal.systems.commands.*;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.dungeon.common.DungeonRoom;
import tsbe.multiversal.systems.*;
import tsbe.multiversal.systems.commands.*;

import java.util.ArrayList;
import java.util.List;

public class GS_Dungeon implements IGameState {

    Dungeon curr_dungeon;
    DungeonRoom current_room;
    int current_room_num;

    List<ICommand> available_commands = new ArrayList<>();

    public GS_Dungeon(Dungeon current_dungeon, int current_room_num){
        curr_dungeon = current_dungeon;
        current_room = current_dungeon.buildRoom(current_room_num);
        this.current_room_num = current_room_num;
        available_commands.add(new CMD_Attack());
        available_commands.add(new CMD_Attack_Spell());
        available_commands.add(new CMD_OpenInventory());
        available_commands.add(new CMD_SpellList());
        available_commands.add(new CMD_LeaveGame());
        available_commands.add(new CMD_Help(this));
    }

    @Override
    public void onStateStart() {
        GlobalUIM.getInstance().displayDungeonEntering(curr_dungeon, current_room_num);
        GlobalGameManager.getInstance().player.addListener(current_room);
        GameStateManager.getInstance().resumeState();
    }

    @Override
    public void onStateResume() {
        GlobalUIM.getInstance().displayRoomState(current_room.allies, current_room.enemies);
        String[] argv = new String[]{};

        if(current_room.enemies.size() <= 0){ return; }

        boolean valid = false;
        ICommand curr_cmd = null;
        while(!valid) {
            argv = GlobalUIM.getInstance().askInlineInput(Constants.ASK_NEXT_MOVE).trim().replaceAll(" +", " ").split(" +");
            for(ICommand c : available_commands)
                if(argv[0].equals(c.getPrefix()) && argv.length == c.getArgs()+1 && c.valid(argv, new Object[]{current_room})) { valid = true; curr_cmd = c; }
        }

        curr_cmd.execute(argv, new Object[]{current_room, curr_dungeon});

        GameStateManager.getInstance().resumeState();
    }

    @Override
    public void onPlayerCreated() {}

    @Override
    public void onEnterDungeon(Dungeon dungeon) { // Goes to the next room
        GameStateManager.getInstance().changeState(new GS_Dungeon(curr_dungeon, current_room_num+1));
    }

    @Override
    public void onExitDungeon() {
        GameStateManager.getInstance().changeState(new GS_MainMenu());
    }

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
