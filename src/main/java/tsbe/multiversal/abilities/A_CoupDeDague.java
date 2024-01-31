package tsbe.multiversal.abilities;

import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.systems.GlobalGameManager;

public class A_CoupDeDague implements IAbility {
    @Override
    public String getIdentifier() {
        return "cdd";
    }

    @Override
    public String getName() {
        return "Coup de dague";
    }

    @Override
    public boolean canExecuteAbility(Entity e) {
        return true;
    }

    @Override
    public int getRawDamage() {
        return GlobalGameManager.getInstance().player.getRawAttackDamage() + Math.round(1.7f * GlobalGameManager.getInstance().player.getStats().strength);
    }

    @Override
    public String getDescription() {
        return "Donne un coup discret de dague !";
    }
}
