package tsbe.multiversal.entity.classes;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.EntityClass;

import java.util.List;

public class EC_Robot implements EntityClass {
    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.health += 15;
        return base_stats;
    }

    @Override
    public String getName() {
        return "Robot";
    }

    @Override
    public PlayerClassType getClassType() {
        return null;
    }

    @Override
    public Stats getStats() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Bip boop";
    }

    @Override
    public List<IAbility> getAbilities() {
        return null;
    }
}
