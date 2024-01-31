package tsbe.multiversal.entity.common;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.Stats;

import java.util.List;

public interface EntityClass {

    enum PlayerClassType {BASE, GODLIKE, ASSASSIN};

    Stats applyEffector(Stats base_stats);
    String getName();
    PlayerClassType getClassType();
    Stats getStats();
    String getDescription();
    List<IAbility> getAbilities();

}
