package tsbe.multiversal.entity.common;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.IObservable;
import tsbe.multiversal.common.IObserver;
import tsbe.multiversal.common.Stats;

import java.util.*;

public class Entity implements IObservable {

    List<IObserver> observers = new ArrayList<>();

    @Override
    public void notify(IObserver.NotificationType type) {
        for (IObserver observer : observers) observer.onNotification(type, this);
    }

    @Override
    public void notify(IObserver.NotificationType type, Object[] data) {
        for (IObserver observer : observers) observer.onNotification(type, this, data);
    }

    @Override
    public void addListener(IObserver o) {
        if(!observers.contains(o)) observers.add(o);
    }

    @Override
    public void removeListener(IObserver o) {
        if(observers.contains(o)) observers.remove(o);
    }

    public enum EntityType {PLAYER, SQUELETTE, ROBOT, ASSASSIN}

    // Properties
    public String name;
    public int lifepoints;
    public int base_lifepoints;
    public int start_lifepoints;
    public EntityClass entityClass;
    public EntityType type;
    public Stats additionnal_stats = new Stats();
    public int experienced_damage_addition = 0;

    // Drops upon entity death, in percents.
    public Map<String,Integer> drop_rates = new HashMap<>();

    public static int base_damage = 5;

    // Returns itself for chaining creation.
    public Entity addDrop(String i, int percentage){drop_rates.put(i,percentage); return this;}

    // Methods
    public int getRawAttackDamage(){
        Stats stats = entityClass.applyEffector(new Stats());
        return base_damage + Math.round(stats.strength * 1.5f) + (new Random().nextInt(10)) + experienced_damage_addition;
    }

    public int getDamageOnEntity(int raw_damage){return raw_damage;}

    public void damage(int raw_damage){
        lifepoints -= raw_damage;
        if(lifepoints <= 0) notify(IObserver.NotificationType.ENTITY_DEATH);
    }

    public Stats getStats(){
        Stats s = new Stats(additionnal_stats);
        s = entityClass.applyEffector(s);
        return s;
    }

    public void heal(int amount){
        if(lifepoints + amount >= base_lifepoints) lifepoints = base_lifepoints;
        else lifepoints += amount;
    }

    public List<IAbility> getAbilities(){
        List<IAbility> abilities = new ArrayList<>();
        if(entityClass.getAbilities() != null && entityClass.getAbilities().size() > 0)
            for(IAbility a : entityClass.getAbilities()) if(!abilities.contains(a)) abilities.add(a);
        return abilities;
    }

}
