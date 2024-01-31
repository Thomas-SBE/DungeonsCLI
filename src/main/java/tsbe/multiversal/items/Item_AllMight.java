package tsbe.multiversal.items;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.Item;
import tsbe.multiversal.systems.GlobalGameManager;

public class Item_AllMight implements Item
{
    @Override
    public void use(Entity e) {
        GlobalGameManager.getInstance().player.removeItem(this.getID());
        for(String id : GlobalGameManager.getInstance().itemRegistry.keySet()){
            GlobalGameManager.getInstance().player.addItem(id);
        }
    }

    @Override
    public String getName() {
        return "ALL MIGHT";
    }

    @Override
    public String getID() {
        return ItemIDs.ITEM_ALL_MIGHT;
    }

    @Override
    public String getDescription() {
        return "undefined but broken";
    }
}
