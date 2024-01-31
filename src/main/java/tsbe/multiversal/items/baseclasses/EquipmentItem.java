package tsbe.multiversal.items.baseclasses;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.Stats;

import java.util.List;

public interface EquipmentItem extends Item{
    enum EquipmentType {HELMET, TORSO, LEGS, SHOES, ATTACK};
    EquipmentType getEquipmentType();
    Stats applyEffector(Stats base_stats);
    List<IAbility> getAbilities();
}
