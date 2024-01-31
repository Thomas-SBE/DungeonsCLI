package tsbe.multiversal.items;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.Item;

public class Item_PommeOr implements Item {
    @Override
    public void use(Entity e) {
        e.heal(100);
    }

    @Override
    public String getName() {
        return "Pomme d'or";
    }

    @Override
    public String getID() {
        return ItemIDs.ITEM_GOLDEN_APPLE;
    }

    @Override
    public String getDescription() {
        return "Note : Cheh ?!";
    }
}
