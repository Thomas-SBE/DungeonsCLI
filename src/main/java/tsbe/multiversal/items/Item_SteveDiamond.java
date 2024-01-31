package tsbe.multiversal.items;

import tsbe.multiversal.abilities.A_Fireball;
import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.EquipmentItem;

import java.util.Arrays;
import java.util.List;

public class Item_SteveDiamond implements EquipmentItem {
    @Override
    public void use(Entity e) {

    }

    @Override
    public String getName() {
        return "Plastron en diamand de Steve";
    }

    @Override
    public String getID() {
        return ItemIDs.TORSO_STEVE;
    }

    @Override
    public String getDescription() {
        return "8 diamands pour un plastron !";
    }

    @Override
    public EquipmentType getEquipmentType() {
        return EquipmentType.TORSO;
    }

    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.strength += 10;
        return base_stats;
    }

    @Override
    public List<IAbility> getAbilities() {
        return Arrays.asList(new A_Fireball());
    }
}
