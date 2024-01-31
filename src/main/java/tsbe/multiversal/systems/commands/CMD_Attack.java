package tsbe.multiversal.systems.commands;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.common.IObserver;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.dungeon.common.Dungeon;
import tsbe.multiversal.dungeon.common.DungeonRoom;
import tsbe.multiversal.systems.GameStateManager;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.systems.GlobalUIM;
import tsbe.multiversal.systems.ICommand;
import tsbe.multiversal.systems.states.GS_MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CMD_Attack implements ICommand {
    @Override
    public String getPrefix() {
        return "a";
    }

    @Override
    public int getArgs() {
        return 1;
    }

    @Override
    public boolean valid(String[] argv, Object[] data) {
        try {
            int enemy_index = Integer.parseInt(argv[1]);
            DungeonRoom current_room = (DungeonRoom) data[0];
            if (enemy_index >= current_room.enemies.size() || enemy_index < 0) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean execute(String[] argv, Object[] data) {
        int enemy_index = Integer.parseInt(argv[1]);
        DungeonRoom current_room = (DungeonRoom) data[0];
        Dungeon curr_dungeon = (Dungeon) data[1];
        int current_room_num = current_room.current_room_num;
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + GlobalUIM.getInstance().centeredText("", 78, "─") + "┐" + Constants.SCOLOR_RESET);

        // Coup critique !
        int cc_num_you = new Random().nextInt(1000);
        int damage_multiplier = 1;
        if(cc_num_you <= Math.max(1, GlobalGameManager.getInstance().player.getStats().luck))
        {
            damage_multiplier = 2;
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" • %sVous %sfaites un %sCoup critique%s !".formatted(Constants.SCOLOR_GREEN, Constants.SCOLOR_WHITE, Constants.SCOLOR_YELLOW, Constants.SCOLOR_WHITE), 78, " ", 20) + "│");
        }

        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" • %sVous %sinfligez %s%d%s de dégats à [%s%d%s] %s%s%s !".formatted(Constants.SCOLOR_GREEN, Constants.SCOLOR_WHITE, Constants.SCOLOR_YELLOW, current_room.enemies.get(enemy_index).getDamageOnEntity(GlobalGameManager.getInstance().player.getRawAttackDamage()*damage_multiplier), Constants.SCOLOR_WHITE, Constants.SCOLOR_CYAN, enemy_index, Constants.SCOLOR_WHITE, Constants.SCOLOR_RED, current_room.enemies.get(enemy_index).name, Constants.SCOLOR_WHITE), 78, " ", 40) + "│");
        current_room.enemies.get(enemy_index).damage(GlobalGameManager.getInstance().player.getRawAttackDamage() * damage_multiplier);

        // Allies attack enemies
        for (int i = 0; i < current_room.allies.size(); i++) {
            List<Entity> targets = new ArrayList<>(current_room.enemies);
            if(targets.size() <= 0) break;
            // Coup critique !
            int cc_num_a = new Random().nextInt(1000);
            int damage_multiplier_a = 1;
            if(cc_num_a <= current_room.allies.get(i).getStats().luck)
            {
                damage_multiplier_a = 2;
                System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" • %s%s%s fait un %sCoup critique%s !".formatted(Constants.SCOLOR_GREEN, current_room.allies.get(i).name, Constants.SCOLOR_WHITE, Constants.SCOLOR_YELLOW, Constants.SCOLOR_WHITE), 78, " ", 20) + "│");
            }
            int rand_index = new Random().nextInt(targets.size());
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" • %s%s%s inflige %s%d%s de dégats à [%s%d%s] %s%s%s !".formatted(Constants.SCOLOR_GREEN,current_room.allies.get(i).name,Constants.SCOLOR_WHITE,Constants.SCOLOR_YELLOW,targets.get(rand_index).getDamageOnEntity(current_room.allies.get(i).getRawAttackDamage() * damage_multiplier_a),Constants.SCOLOR_WHITE, Constants.SCOLOR_CYAN, rand_index, Constants.SCOLOR_WHITE, Constants.SCOLOR_RED,targets.get(rand_index).name,Constants.SCOLOR_WHITE), 78, " ", 40) + "│");
            targets.get(rand_index).damage(current_room.allies.get(i).getRawAttackDamage() * damage_multiplier_a);
        }

        // Enemies attack You
        for (int i = 0; i < current_room.enemies.size(); i++) {
            List<Entity> targets = new ArrayList<>(current_room.allies);
            if(GlobalGameManager.getInstance().player_alive) targets.add(GlobalGameManager.getInstance().player);
            if(targets.size() <= 0) break;
            // Coup critique !
            int cc_num_e = new Random().nextInt(1000);
            int damage_multiplier_e = 1;
            if(cc_num_e <= current_room.enemies.get(i).getStats().luck)
            {
                damage_multiplier_e = 2;
                System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" • %s%s%s fait un %sCoup critique%s !".formatted(Constants.SCOLOR_RED, current_room.enemies.get(i).name, Constants.SCOLOR_WHITE, Constants.SCOLOR_YELLOW, Constants.SCOLOR_WHITE), 78, " ", 20) + "│");
            }
            int rand_index = new Random().nextInt(targets.size());
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + GlobalUIM.getInstance().filledText(" • [%s%d%s] %s%s%s inflige %s%d%s de dégats à %s%s%s !".formatted(Constants.SCOLOR_CYAN,i,Constants.SCOLOR_WHITE,Constants.SCOLOR_RED,current_room.enemies.get(i).name,Constants.SCOLOR_WHITE,Constants.SCOLOR_YELLOW,targets.get(rand_index).getDamageOnEntity(current_room.enemies.get(i).getRawAttackDamage() * damage_multiplier_e),Constants.SCOLOR_WHITE,Constants.SCOLOR_GREEN,targets.get(rand_index).name,Constants.SCOLOR_WHITE), 78, " ", 40) + "│");
            targets.get(rand_index).damage(current_room.enemies.get(i).getRawAttackDamage() * damage_multiplier_e);
        }

        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);

        // If no more enemies
        if(current_room.enemies.size() <= 0){
            GlobalGameManager.getInstance().player.notify(IObserver.NotificationType.DUNGEON_ROOM_FINISHED, new Object[]{curr_dungeon, current_room});
            if(curr_dungeon.canExitAt(current_room_num)){
                if(curr_dungeon.getNumberOfRoom()-1 == current_room_num) { GlobalGameManager.getInstance().player.notify(IObserver.NotificationType.DUNGEON_FINISHED, new Object[]{curr_dungeon, current_room}); GameStateManager.getInstance().changeState(new GS_MainMenu()); return true; }
                while(true){
                    String val = GlobalUIM.getInstance().askInput(Constants.ASK_EXIT_DUNGEON);
                    if(val.trim().equals("o") || val.trim().equals("oui")) { GameStateManager.getInstance().changeState(new GS_MainMenu()); return true; }
                    else if(val.trim().equals("n") || val.trim().equals("non")) { break; }
                }
            }
            GameStateManager.getInstance().enterDungeon(curr_dungeon);
        }

        return true;
    }

    @Override
    public String getHelpDesc() {
        return GlobalUIM.getInstance().filledText(" %sAttaquer ennemi :%s a %s<index_ennemi>%s".formatted(Constants.SCOLOR_YELLOW, Constants.SCOLOR_GREEN, Constants.SCOLOR_CYAN, Constants.SCOLOR_RESET), 78, " ", 19);
    }
}
