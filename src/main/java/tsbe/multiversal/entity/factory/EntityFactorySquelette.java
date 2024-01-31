package tsbe.multiversal.entity.factory;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.E_Squelette;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.systems.GlobalGameManager;

import java.util.Random;

public class EntityFactorySquelette implements EntityFactory{
    @Override
    public Entity buildEntity(String name, int lifepoints) {
        Entity e = new E_Squelette();
        e.name = name;
        e.lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.start_lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.base_lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.type = Entity.EntityType.SQUELETTE;
        e.experienced_damage_addition = (5+(new Random().nextInt(6))) * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.addDrop(ItemIDs.ATTACK_WOODEN_SWORD, 10);
        return e;
    }
}
