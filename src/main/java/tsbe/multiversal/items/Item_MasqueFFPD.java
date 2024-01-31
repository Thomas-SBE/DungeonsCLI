package tsbe.multiversal.items;

import tsbe.multiversal.abilities.A_Hyroalcoolique;
import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.EquipmentItem;

import java.util.Arrays;
import java.util.List;

public class Item_MasqueFFPD implements EquipmentItem {
    @Override
    public EquipmentType getEquipmentType() {
        return EquipmentType.HELMET;
    }

    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.health += 10;
        return base_stats;
    }

    @Override
    public List<IAbility> getAbilities() {
        return Arrays.asList(new A_Hyroalcoolique());
    }

    @Override
    public void use(Entity e) {

    }

    @Override
    public String getName() {
        return "Masque FFP2";
    }

    @Override
    public String getID() {
        return ItemIDs.HELMET_MASQUE_FFPD;
    }

    @Override
    public String getDescription() {
        return "Les gestes barrière.";
    }
}
