package tsbe.multiversal.items;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.entity.common.Player;
import tsbe.multiversal.items.baseclasses.Item;

import java.util.Random;

public class Item_PotionXp implements Item {
    @Override
    public void use(Entity e) {
        int pick = new Random().nextInt(100);
        if(!(e instanceof Player p)) return;
        // 1% : 10k, 4% : 1.5k, 5% : 1k, 50% : 100, 25% : 150, 10% : 250, 5% : 1
        if(pick <= 1) p.gainExperience(10000f);
        else if(pick <= 5) p.gainExperience(1500f);
        else if(pick <= 10) p.gainExperience(1000f);
        else if(pick <= 60) p.gainExperience(100f);
        else if(pick <= 85) p.gainExperience(150f);
        else if(pick <= 95) p.gainExperience(250f);
        else p.gainExperience(1f);
    }

    @Override
    public String getName() {
        return "Potion d'Expérience";
    }

    @Override
    public String getID() {
        return ItemIDs.ITEM_XP_POTION;
    }

    @Override
    public String getDescription() {
        return "Lucky blocks !";
    }
}
