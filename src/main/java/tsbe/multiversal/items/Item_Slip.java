package tsbe.multiversal.items;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.EquipmentItem;

import java.util.List;

public class Item_Slip implements EquipmentItem {
    @Override
    public EquipmentType getEquipmentType() {
        return EquipmentType.LEGS;
    }

    @Override
    public Stats applyEffector(Stats base_stats) {
        return base_stats;
    }

    @Override
    public List<IAbility> getAbilities() {
        return null;
    }

    @Override
    public void use(Entity e) {

    }

    @Override
    public String getName() {
        return "Le Slibard";
    }

    @Override
    public String getID() {
        return ItemIDs.LEGS_SLIP;
    }

    @Override
    public String getDescription() {
        return "Le minimum légal ...";
    }
}
