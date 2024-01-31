package tsbe.multiversal.items;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.EquipmentItem;

import java.util.ArrayList;
import java.util.List;

public class Item_WoodenSword implements EquipmentItem {
    @Override
    public EquipmentType getEquipmentType() {
        return EquipmentType.ATTACK;
    }

    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.strength += 2;
        return base_stats;
    }

    @Override
    public List<IAbility> getAbilities() {
        return new ArrayList<>();
    }

    @Override
    public void use(Entity e) {

    }

    @Override
    public String getName() {
        return "Epée en bois";
    }

    @Override
    public String getID() {
        return ItemIDs.ATTACK_WOODEN_SWORD;
    }

    @Override
    public String getDescription() {
        return "Très basique ...";
    }
}
