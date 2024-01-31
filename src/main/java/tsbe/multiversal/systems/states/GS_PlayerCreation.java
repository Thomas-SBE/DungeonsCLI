package tsbe.multiversal.systems.states;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.common.PlayerBuilder;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.systems.*;
import tsbe.multiversal.systems.*;

import java.util.List;

public class GS_PlayerCreation implements IGameState {

    @Override
    public void onStateStart() {
        int amount_of_players = 1;

        for(int i = 0; i < amount_of_players; i++)
        {
            PlayerBuilder build = new PlayerBuilder();
            boolean correct = false;
            while(!correct) correct = build.setPlayerName(GlobalUIM.getInstance().askInput(Constants.ASK_NAME_STRING.formatted(amount_of_players>1?String.format("#%d ", i):"")));
            GlobalUIM.getInstance().displayClassList();
            correct = false;
            while(!correct) correct = build.setPlayerClass(GlobalUIM.getInstance().askInput(Constants.ASK_CLASS_STRING.formatted(amount_of_players>1?String.format("#%d ", i):"")));
            GlobalGameManager.getInstance().player = build.getPlayerResult();
            GlobalGameManager.getInstance().player_alive = true;

            GlobalGameManager.getInstance().player.addItem(ItemIDs.ITEM_GOLDEN_APPLE);
            GlobalGameManager.getInstance().player.addItem(ItemIDs.HELMET_MASQUE_FFPD);
        }

        onPlayerCreated();
    }

    @Override
    public void onStateResume() {

    }

    @Override
    public void onPlayerCreated() {
        GameStateManager.getInstance().changeState(new GS_MainMenu());
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

    }

    @Override
    public void onInventoryClose() {

    }

    @Override
    public List<ICommand> getAvailableCommands() {
        return null;
    }
}
