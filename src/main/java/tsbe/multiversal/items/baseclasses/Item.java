package tsbe.multiversal.items.baseclasses;

import tsbe.multiversal.entity.common.Entity;

public interface Item {
    void use(Entity e);
    String getName();
    String getID();
    String getDescription();
}
