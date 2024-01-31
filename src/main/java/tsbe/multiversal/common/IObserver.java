package tsbe.multiversal.common;

public interface IObserver {

    enum NotificationType {PLAYER_DEATH, ENTITY_DEATH, PLAYER_LEVELUP, PLAYER_REVIVE, DUNGEON_FINISHED, DUNGEON_ROOM_FINISHED}

    void onNotification(NotificationType type, Object source);
    void onNotification(NotificationType type, Object source, Object[] data);

}
