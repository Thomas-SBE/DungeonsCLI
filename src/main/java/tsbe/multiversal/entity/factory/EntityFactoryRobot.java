package tsbe.multiversal.entity.factory;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.E_Robot;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.systems.GlobalGameManager;

import java.util.Random;

public class EntityFactoryRobot implements EntityFactory{
    @Override
    public Entity buildEntity(String name, int lifepoints) {
        Entity e = new E_Robot();
        e.name = name;
        e.lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.start_lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.base_lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.type = Entity.EntityType.ROBOT;
        e.experienced_damage_addition = (5+(new Random().nextInt(6))) * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.addDrop(ItemIDs.TORSO_CRYSTAL, 2);
        e.addDrop(ItemIDs.SHOES_CRYSTAL, 2);
        return e;
    }
}
