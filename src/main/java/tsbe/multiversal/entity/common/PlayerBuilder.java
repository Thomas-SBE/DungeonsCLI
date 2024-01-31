package tsbe.multiversal.entity.common;

import tsbe.multiversal.entity.classes.EC_Assassins;
import tsbe.multiversal.entity.classes.EC_Base;
import tsbe.multiversal.entity.classes.EC_Godlike;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.systems.GlobalGameManager;

import java.text.Normalizer;

public class PlayerBuilder {

    private Player p;
    public PlayerBuilder(){ p = new Player(); }

    public static int default_player_lp = 100;

    public String nameToCode(String input){
        input = input.replaceAll(" ", "");
        input = input.toLowerCase();
        input = Normalizer.normalize(input, Normalizer.Form.NFD);
        return input;
    }

    public boolean setPlayerName(String name){ p.name = name; return true; }
    public boolean setPlayerClass(String classname) {
        boolean exists = true;
        switch (nameToCode(classname)){
            case "classedebase" -> p.entityClass = new EC_Base();
            case "dieuvivant" -> p.entityClass = new EC_Godlike();
            case "assassin" -> p.entityClass = new EC_Assassins();
            default -> exists = false;
        }
        return exists;
    }

    public Player getPlayerResult(){
        Stats cs = p.entityClass.applyEffector(new Stats());
        p.base_lifepoints = default_player_lp + 15 * cs.health;
        p.lifepoints = p.base_lifepoints;
        p.start_lifepoints = default_player_lp;
        p.type = Entity.EntityType.PLAYER;
        p.addListener(GlobalGameManager.getInstance());
        return p;
    }

}
