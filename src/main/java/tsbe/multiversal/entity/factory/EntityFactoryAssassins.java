package tsbe.multiversal.entity.factory;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.E_Assassin;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.systems.GlobalGameManager;

import java.util.Random;

public class EntityFactoryAssassins implements EntityFactory{
    @Override
    public Entity buildEntity(String name, int lifepoints) {
        Entity e = new E_Assassin();
        e.name = name;
        e.lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.start_lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.base_lifepoints = lifepoints + lifepoints * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.type = Entity.EntityType.ASSASSIN;
        e.experienced_damage_addition = (5+(new Random().nextInt(6))) * Math.round(GlobalGameManager.getInstance().player.level*0.75f);
        e.addDrop(ItemIDs.ATTACK_HIDDEN_BLADE, 10);
        e.addDrop(ItemIDs.ATTACK_LASER_BLADE, 5);
        e.addDrop(ItemIDs.ITEM_GOLDEN_APPLE, 50);
        e.addDrop(ItemIDs.TORSO_CRYSTAL, 5);
        e.addDrop(ItemIDs.SHOES_CRYSTAL, 5);
        return e;
    }
}
