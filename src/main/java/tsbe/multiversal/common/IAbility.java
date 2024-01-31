package tsbe.multiversal.common;

import tsbe.multiversal.entity.common.Entity;

public interface IAbility {

    String getIdentifier();
    String getName();
    boolean canExecuteAbility(Entity e);
    int getRawDamage();
    String getDescription();

}
