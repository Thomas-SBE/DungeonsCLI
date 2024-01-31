package tsbe.multiversal.abilities;

import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.common.IAbility;

public class A_Fireball implements IAbility {
    @Override
    public String getIdentifier() {
        return "fireball";
    }

    @Override
    public String getName() {
        return "Boule de feu";
    }

    @Override
    public boolean canExecuteAbility(Entity e) {
        return true;
    }

    @Override
    public int getRawDamage() {
        return 9999;
    }

    @Override
    public String getDescription() {
        return "Adoken";
    }
}
