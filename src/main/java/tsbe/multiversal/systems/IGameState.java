package tsbe.multiversal.systems;

import tsbe.multiversal.dungeon.common.Dungeon;

import java.util.List;

public interface IGameState {

    void onStateStart();
    void onStateResume();

    void onPlayerCreated();
    void onEnterDungeon(Dungeon dungeon);
    void onExitDungeon();
    void onPlayerDeath();
    void onPlayerFinalDeath();
    void onPlayerRevive();

    void onInventoryOpen();
    void onInventoryClose();

    List<ICommand> getAvailableCommands();

}
