package tsbe.multiversal.dungeon;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.dungeon.common.DungeonRoom;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.entity.factory.EntityFactory;
import tsbe.multiversal.entity.factory.EntityFactoryAssassins;
import tsbe.multiversal.systems.GlobalGameManager;

public class D_TempleAssassins implements Dungeon {

    public static D_TempleAssassins INSTANCE;
    public static D_TempleAssassins getInstance() { if(INSTANCE == null) INSTANCE = new D_TempleAssassins(); return INSTANCE; }

    @Override
    public String getName() {
        return "Matrice des Assassins";
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

        EntityFactory factory = new EntityFactoryAssassins();

        switch (room_number){
            case 0 -> {
                room.enemies.add(factory.buildEntity("Novice Bob", 30));
                room.enemies.add(factory.buildEntity("Novice Anna", 30));
                room.enemies.add(factory.buildEntity("Novice Jean", 30));
            }
            case 1 -> {
                room.enemies.add(factory.buildEntity("Ceinture Bleu Maxime", 45));
                room.enemies.add(factory.buildEntity("Ceinture Blanche Aurore", 45));
                room.enemies.add(factory.buildEntity("Ceinture Rouge Mathis", 45));
            }
            case 2 -> {
                room.enemies.add(factory.buildEntity("Maitre Neo", 64));
                room.enemies.add(factory.buildEntity("Novice Trinity", 30));
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
        GlobalGameManager.getInstance().player.addItem(ItemIDs.ITEM_ALL_MIGHT);
    }
}
