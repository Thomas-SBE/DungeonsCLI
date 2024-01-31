package tsbe.multiversal.entity.classes;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.EntityClass;

import java.util.List;

public class EC_Base implements EntityClass {

    @Override
    public Stats applyEffector(Stats base_stats) {
        return base_stats;
    }

    @Override
    public String getName() {
        return "Classe de base";
    }

    @Override
    public PlayerClassType getClassType() {
        return PlayerClassType.BASE;
    }

    @Override
    public Stats getStats() {
        return null;
    }

    @Override
    public String getDescription() {
        return "La classe la plus basique, tout est par défaut.";
    }

    @Override
    public List<IAbility> getAbilities() {
        return null;
    }
}
