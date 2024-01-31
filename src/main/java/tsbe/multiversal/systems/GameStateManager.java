package tsbe.multiversal.systems;

import tsbe.multiversal.systems.states.GS_PlayerCreation;
import tsbe.multiversal.dungeon.common.Dungeon;

public class GameStateManager {

    // Singleton
    private static GameStateManager INSTANCE = null;
    public static GameStateManager getInstance(){ if(INSTANCE == null){INSTANCE = new GameStateManager();} return INSTANCE; }

    private IGameState current_gamestate;

    public void initialize() { changeState(new GS_PlayerCreation()); }

    public void changeState(IGameState new_state) { current_gamestate = new_state; initState(); }
    public void changeState(IGameState new_state, boolean doesInit) { current_gamestate = new_state; if(doesInit) initState(); }

    public void initState() { current_gamestate.onStateStart(); }
    public void resumeState() { current_gamestate.onStateResume(); }
    public void playerCreated() { current_gamestate.onPlayerCreated(); }
    public void enterDungeon(Dungeon dungeon) { current_gamestate.onEnterDungeon(dungeon); }
    public void exitDungeon() { current_gamestate.onExitDungeon(); }
    public void killPlayer() { current_gamestate.onPlayerDeath(); }
    public void finalKillPlayer() { current_gamestate.onPlayerFinalDeath(); }
    public void revivePlayer() { current_gamestate.onPlayerRevive(); }
    public void openInventory() { current_gamestate.onInventoryOpen(); }
    public void closeInventory() { current_gamestate.onInventoryClose(); }

}
