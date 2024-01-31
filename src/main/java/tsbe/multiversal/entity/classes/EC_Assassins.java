package tsbe.multiversal.entity.classes;

import tsbe.multiversal.abilities.A_CoupDeDague;
import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.common.EntityClass;

import java.util.Arrays;
import java.util.List;

public class EC_Assassins implements EntityClass {
    @Override
    public Stats applyEffector(Stats base_stats) {
        base_stats.health += 1;
        base_stats.luck += 100;
        base_stats.strength += 2;
        return base_stats;
    }

    @Override
    public String getName() {
        return "Assassin";
    }

    @Override
    public PlayerClassType getClassType() {
        return PlayerClassType.ASSASSIN;
    }

    @Override
    public Stats getStats() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Vous êtes discret et étrangement chanceux...";
    }

    @Override
    public List<IAbility> getAbilities() {
        return Arrays.asList(new A_CoupDeDague());
    }
}
