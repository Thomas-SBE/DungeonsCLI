package tsbe.multiversal.dungeon;

import tsbe.multiversal.common.ItemIDs;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.dungeon.common.DungeonRoom;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.entity.factory.EntityFactory;
import tsbe.multiversal.entity.factory.EntityFactoryRobot;
import tsbe.multiversal.systems.GlobalGameManager;

public class D_Terminator implements Dungeon {

    public static D_Terminator INSTANCE;
    public static D_Terminator getInstance() { if(INSTANCE == null) INSTANCE = new D_Terminator(); return INSTANCE; }

    @Override
    public String getName() {
        return "Donjon de l'année 2043";
    }

    @Override
    public int getNumberOfRoom() {
        return 4;
    }

    @Override
    public DungeonRoom buildRoom(int room_number) {
        DungeonRoom room = new DungeonRoom();
        room.parent_dungeon = this;
        room.current_room_num = room_number;

        EntityFactory robotFac = new EntityFactoryRobot();

        switch (room_number){
            case 0 -> {
                room.allies.add(robotFac.buildEntity("T-800", 100));
                room.enemies.add(robotFac.buildEntity("Roomba", 15).addDrop(ItemIDs.ITEM_MASTERCARD, 1));
                room.enemies.add(robotFac.buildEntity("Roomba", 15).addDrop(ItemIDs.ITEM_MASTERCARD, 1));
                room.enemies.add(robotFac.buildEntity("Roomba", 15).addDrop(ItemIDs.ITEM_MASTERCARD, 1));
                room.enemies.add(robotFac.buildEntity("Roomba", 15).addDrop(ItemIDs.ITEM_MASTERCARD, 1));
                room.enemies.add(robotFac.buildEntity("Roomba", 15).addDrop(ItemIDs.ITEM_MASTERCARD, 1));
            }
            case 1 -> {
                room.allies.add(robotFac.buildEntity("T-800", 100));
                room.enemies.add(robotFac.buildEntity("Blender", 35).addDrop(ItemIDs.ATTACK_LASER_BLADE, 10));
                room.enemies.add(robotFac.buildEntity("Roomba", 15));
                room.enemies.add(robotFac.buildEntity("Model 101", 40).addDrop(ItemIDs.ITEM_GOLDEN_APPLE, 50).addDrop(ItemIDs.ATTACK_LASER_BLADE, 15));
            }
            case 2 -> {
                room.allies.add(robotFac.buildEntity("T-800", 100));
                room.enemies.add(robotFac.buildEntity("Blender", 35).addDrop(ItemIDs.ITEM_TREFLE, 10));
                room.enemies.add(robotFac.buildEntity("Blender de bronze", 35).addDrop(ItemIDs.ITEM_TREFLE, 10));
                room.enemies.add(robotFac.buildEntity("Blender d'or", 35).addDrop(ItemIDs.ITEM_TREFLE, 10));
            }
            case 3 -> {
                room.allies.add(robotFac.buildEntity("T-90", 150));
                room.enemies.add(robotFac.buildEntity("Cyberdyne Systems", 250).addDrop(ItemIDs.ITEM_MASTERCARD, 250).addDrop(ItemIDs.ATTACK_LASER_BLADE, 50));
            }
            default -> {}
        }

        for(Entity e : room.enemies) e.addListener(room);
        for(Entity e : room.allies) e.addListener(room);

        return room;
    }

    @Override
    public boolean canExitAt(int room_num) {
        return room_num == 1 || room_num == 3;
    }

    @Override
    public void onDungeonFinished() {
        GlobalGameManager.getInstance().unlockDungeon(D_TempleAssassins.getInstance());
    }
}
