package tsbe.multiversal.items;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.EquipmentItem;

import java.util.List;

public class Item_Fez implements EquipmentItem {
    @Override
    public EquipmentType getEquipmentType() {
        return EquipmentType.HELMET;
    }

    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.luck += 15;
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
        return "Fez";
    }

    @Override
    public String getID() {
        return ItemIDs.HELMET_FEZ;
    }

    @Override
    public String getDescription() {
        return "Les fez, c'est classe, enfin c'est ce que le Docteur a dit...";
    }
}
