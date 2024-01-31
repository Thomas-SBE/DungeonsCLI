package tsbe.multiversal.abilities;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.systems.GlobalGameManager;

public class A_Hyroalcoolique implements IAbility {
    @Override
    public String getIdentifier() {
        return "gha";
    }

    @Override
    public String getName() {
        return "Gel Hydroalcoolique";
    }

    @Override
    public boolean canExecuteAbility(Entity e) {
        return true;
    }

    @Override
    public int getRawDamage() {
        return GlobalGameManager.getInstance().player.getRawAttackDamage() + Math.round(1.5f * GlobalGameManager.getInstance().player.getStats().luck);
    }

    @Override
    public String getDescription() {
        return "Nous sommes en guerre !";
    }
}
