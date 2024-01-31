package tsbe.multiversal.dungeon.common;

public interface Dungeon {

    String getName();
    int getNumberOfRoom();
    DungeonRoom buildRoom(int room_number);
    boolean canExitAt(int room_num);
    void onDungeonFinished();

}
