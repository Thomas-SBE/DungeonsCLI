package tsbe.multiversal.entity.factory;

import tsbe.multiversal.entity.common.Entity;

public interface EntityFactory {

    Entity buildEntity(String name, int lifepoints);

}
