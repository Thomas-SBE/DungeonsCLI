package tsbe.multiversal.items;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.Item;
import tsbe.multiversal.systems.GlobalGameManager;

public class Item_Trefle implements Item {
    @Override
    public void use(Entity e) {
        GlobalGameManager.getInstance().player.additionnal_stats.luck += 20;
    }

    @Override
    public String getName() {
        return "Trefle 3 Feuilles";
    }

    @Override
    public String getID() {
        return ItemIDs.ITEM_TREFLE;
    }

    @Override
    public String getDescription() {
        return "Le chance soit avec vous !";
    }
}
