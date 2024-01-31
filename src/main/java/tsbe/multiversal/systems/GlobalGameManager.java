package tsbe.multiversal.systems;

import tsbe.multiversal.common.IObserver;
import tsbe.multiversal.entity.common.Player;
import tsbe.multiversal.items.baseclasses.Item;
import tsbe.multiversal.systems.states.GS_DeathScreen;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.dungeon.common.DungeonRoom;

import java.util.*;

public class GlobalGameManager implements IObserver {

    // Singleton
    private static GlobalGameManager INSTANCE = null;
    public static GlobalGameManager getInstance(){ if(INSTANCE == null){INSTANCE = new GlobalGameManager();} return INSTANCE; }

    // Players Management
    public Player player;
    public boolean player_alive;

    // Item Registry
    public Map<String, Item> itemRegistry = new HashMap<>();
    public void registerItem(Item i){ itemRegistry.put(i.getID(), i); }
    public Item getItemFromID(String id){
        List<String> keys = new ArrayList<>(itemRegistry.keySet());
        if(!keys.contains(id)) return null;
        return itemRegistry.get(id);
    }

    public List<Dungeon> availableDungeons = new ArrayList<>();
    public void unlockDungeon(Dungeon dungeon){
        for(Dungeon d : availableDungeons){
            if(d.getClass().equals(dungeon.getClass())) { return; }
        }
        availableDungeons.add(dungeon);
    }

    @Override
    public void onNotification(NotificationType type, Object source) {
        onNotification(type, source, null);
    }

    @Override
    public void onNotification(NotificationType type, Object source, Object[] data) {
        if(type == NotificationType.PLAYER_DEATH){
            player_alive = false;
            GameStateManager.getInstance().changeState(new GS_DeathScreen(), false);
        }else if(type == NotificationType.PLAYER_LEVELUP){
            player.additionnal_stats.strength += 2 * player.level;
            player.additionnal_stats.health += Math.round(1.5f * player.level);
            player.lifepoints = player.start_lifepoints + Math.round(3.5f*player.additionnal_stats.health);
            player.base_lifepoints = player.lifepoints;
        }else if(type == NotificationType.PLAYER_REVIVE){
            player_alive = true;
            player.lifepoints = 1;
            player.money *= 0.5f;
            List<String> keys = new ArrayList<>(player.getInventory().keySet());
            for(String k : keys)
                if(new Random().nextInt(100) <= 75) player.removeItem(k, 1 + new Random().nextInt(5));
        }else if(type == NotificationType.DUNGEON_FINISHED){
            Dungeon dg = (Dungeon) data[0];
            dg.onDungeonFinished();
        }else if(type == NotificationType.DUNGEON_ROOM_FINISHED){
            DungeonRoom dr = (DungeonRoom) data[1];
            dr.onRoomFinished();
        }
    }
}
