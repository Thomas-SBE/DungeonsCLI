package tsbe.multiversal.items;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.EquipmentItem;

import java.util.ArrayList;
import java.util.List;

public class Item_CrystalTorso implements EquipmentItem {
    @Override
    public EquipmentType getEquipmentType() {
        return EquipmentType.TORSO;
    }

    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.health += 55;
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
        return "Plastron de Crystal";
    }

    @Override
    public String getID() {
        return ItemIDs.TORSO_CRYSTAL;
    }

    @Override
    public String getDescription() {
        return "Très résistant !";
    }
}
