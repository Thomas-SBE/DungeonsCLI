package tsbe.multiversal.entity.classes;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.EntityClass;

import java.util.List;

public class EC_Godlike implements EntityClass {

    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.health += 999;
        base_stats.strength += 999;
        base_stats.luck += 999;
        return base_stats;
    }

    @Override
    public String getName() {
        return "Dieu vivant";
    }

    @Override
    public PlayerClassType getClassType() {
        return PlayerClassType.GODLIKE;
    }

    @Override
    public Stats getStats() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Toutes les stats sont a 999 ...";
    }

    @Override
    public List<IAbility> getAbilities() {
        return null;
    }
}
