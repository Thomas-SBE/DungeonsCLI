package tsbe.multiversal.dungeon;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.dungeon.common.DungeonRoom;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.entity.factory.EntityFactorySquelette;
import tsbe.multiversal.systems.GlobalGameManager;

public class D_Proto implements Dungeon {

    public static D_Proto INSTANCE;
    public static D_Proto getInstance() { if(INSTANCE == null) INSTANCE = new D_Proto(); return INSTANCE; }

    @Override
    public String getName() {
        return "Donjon de prototype";
    }

    @Override
    public int getNumberOfRoom() {
        return 3;
    }

    @Override
    public DungeonRoom buildRoom(int room_number) {
        DungeonRoom room = new DungeonRoom();
        room.parent_dungeon = this;
        room.current_room_num = room_number;

        switch (room_number){
            case 0 -> {
                room.allies.add(new EntityFactorySquelette().buildEntity("Friendly Bob", 15));
                room.enemies.add(new EntityFactorySquelette().buildEntity("Bill bois", 50).addDrop(ItemIDs.ITEM_GOLDEN_APPLE, 100).addDrop(ItemIDs.ITEM_XP_POTION, 25));
                room.enemies.add(new EntityFactorySquelette().buildEntity("Bono-jean", 55));
            }
            case 1 -> {
                room.enemies.add(new EntityFactorySquelette().buildEntity("Skeletron", 150));
            }
            case 2 -> {
                room.enemies.add(new EntityFactorySquelette().buildEntity("Big Boss Skeletron", 1500).addDrop(ItemIDs.ITEM_ALL_MIGHT, 100));
            }
            default -> {}
        }

        for(Entity e : room.enemies) e.addListener(room);
        for(Entity e : room.allies) e.addListener(room);

        return room;
    }

    @Override
    public boolean canExitAt(int room_num) {
        return room_num == 1 || room_num == 2;
    }

    @Override
    public void onDungeonFinished() {
        GlobalGameManager.getInstance().unlockDungeon(D_Terminator.getInstance());
        GlobalGameManager.getInstance().unlockDungeon(D_TempleAssassins.getInstance());
    }
}
