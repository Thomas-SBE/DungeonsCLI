package tsbe.multiversal.dungeon.common;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.common.IObserver;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.systems.GlobalUIM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DungeonRoom implements IObserver {

    public Dungeon parent_dungeon;
    public int current_room_num;

    public List<Entity> allies = new ArrayList<>();
    public List<Entity> enemies = new ArrayList<>();

    public List<Entity> dead_enemies = new ArrayList<>();

    @Override
    public void onNotification(NotificationType type, Object source) {
        onNotification(type, source, null);
    }

    @Override
    public void onNotification(NotificationType type, Object source, Object[] data) {
        if(type == NotificationType.ENTITY_DEATH){
            if(enemies.contains((Entity)source)){
                enemies.remove((Entity) source);
                dead_enemies.add((Entity) source);
                System.out.println("│" + GlobalUIM.getInstance().filledText(" • %s%s%s est mort !".formatted(Constants.SCOLOR_RED,((Entity) source).name, Constants.SCOLOR_WHITE), 78, " ", 10) + "│");
                int randomize = new Random().nextInt(100);
                for(Map.Entry<String,Integer> e : ((Entity)source).drop_rates.entrySet())
                    if(randomize <= e.getValue())
                    {
                        GlobalGameManager.getInstance().player.addItem(e.getKey());
                        System.out.println("│" + GlobalUIM.getInstance().filledText(" • %s%s%s a laisser tomber un(e) %s%s%s !".formatted(Constants.SCOLOR_RED,((Entity) source).name, Constants.SCOLOR_WHITE, Constants.SCOLOR_YELLOW, GlobalGameManager.getInstance().getItemFromID(e.getKey()).getName(), Constants.SCOLOR_WHITE), 78, " ", 20) + "│");
                    }
                boolean hasGainedLevel = GlobalGameManager.getInstance().player.gainExperience(((Entity) source).base_lifepoints * 0.75f);
                if(hasGainedLevel)
                    System.out.println("│" + GlobalUIM.getInstance().filledText(" • %sVous%s êtes passé au niveau %s%d%s !".formatted(Constants.SCOLOR_GREEN, Constants.SCOLOR_WHITE, Constants.SCOLOR_YELLOW, GlobalGameManager.getInstance().player.level, Constants.SCOLOR_WHITE), 78, " ", 20) + "│");
            }else if(allies.contains((Entity)source)){
                allies.remove((Entity) source);
                System.out.println("│" + GlobalUIM.getInstance().filledText(" • %s%s%s est mort !".formatted(Constants.SCOLOR_GREEN,((Entity) source).name, Constants.SCOLOR_WHITE), 78, " ", 10) + "│");
            }
        }
    }

    public void onRoomFinished(){

    }
}
