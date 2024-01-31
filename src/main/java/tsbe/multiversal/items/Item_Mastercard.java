package tsbe.multiversal.items;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.items.baseclasses.Item;
import tsbe.multiversal.systems.GlobalGameManager;

public class Item_Mastercard implements Item {
    @Override
    public void use(Entity e) {
        GlobalGameManager.getInstance().player.money += 1000;
    }

    @Override
    public String getName() {
        return "Mastercard";
    }

    @Override
    public String getID() {
        return ItemIDs.ITEM_MASTERCARD;
    }

    @Override
    public String getDescription() {
        return "Le compte courant !";
    }
}
