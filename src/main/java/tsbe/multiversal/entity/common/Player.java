package tsbe.multiversal.entity.common;

import tsbe.multiversal.common.IAbility;
import tsbe.multiversal.common.IObserver;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.items.baseclasses.EquipmentItem;
import tsbe.multiversal.items.baseclasses.Item;
import tsbe.multiversal.systems.GlobalGameManager;

import java.util.*;

public class Player extends Entity{

    public float expreience;
    public int level;
    public int money;

    // Equipment
    public EquipmentItem equipment_helmet = null;
    public EquipmentItem equipment_torso = null;
    public EquipmentItem equipment_legs = null;
    public EquipmentItem equipment_shoes = null;
    public EquipmentItem equipment_attack = null;

    public void equip(EquipmentItem item){
        switch (item.getEquipmentType())
        {
            case ATTACK -> {
                if(equipment_attack != null) getItem(equipment_attack.getID());
                removeItem(item.getID(), 1);
                equipment_attack = item;
            }
            case HELMET -> {
                if(equipment_helmet != null) getItem(equipment_helmet.getID());
                removeItem(item.getID(), 1);
                equipment_helmet = item;
            }
            case TORSO -> {
                if(equipment_torso != null) getItem(equipment_torso.getID());
                removeItem(item.getID(), 1);
                equipment_torso = item;
            }
            case LEGS -> {
                if(equipment_legs != null) getItem(equipment_legs.getID());
                removeItem(item.getID(), 1);
                equipment_legs = item;
            }
            case SHOES -> {
                if(equipment_shoes != null) getItem(equipment_shoes.getID());
                removeItem(item.getID(), 1);
                equipment_shoes = item;
            }
            default -> { return; }
        }
        Stats add = item.applyEffector(new Stats());
        int old = base_lifepoints;
        base_lifepoints += Math.round(add.health * 1.5f);
        if(lifepoints == old) lifepoints = base_lifepoints;
    }

    public String unequip(EquipmentItem.EquipmentType equipmentType){
        String unequippedID;
        switch (equipmentType){
            case ATTACK -> {
                if(equipment_attack == null) return null;
                addItem(equipment_attack.getID());
                unequippedID = equipment_attack.getID();
                equipment_attack = null;
            }
            case HELMET -> {
                if(equipment_helmet == null) return null;
                addItem(equipment_helmet.getID());
                unequippedID = equipment_helmet.getID();
                equipment_helmet = null;
            }
            case TORSO -> {
                if(equipment_torso == null) return null;
                addItem(equipment_torso.getID());
                unequippedID = equipment_torso.getID();
                equipment_torso = null;
            }
            case LEGS -> {
                if(equipment_legs == null) return null;
                addItem(equipment_legs.getID());
                unequippedID = equipment_legs.getID();
                equipment_legs = null;
            }
            case SHOES -> {
                if(equipment_shoes == null) return null;
                addItem(equipment_shoes.getID());
                unequippedID = equipment_shoes.getID();
                equipment_shoes = null;
            }
            default -> { unequippedID = null; }
        }
        if(unequippedID != null){
            Stats add = ((EquipmentItem)GlobalGameManager.getInstance().getItemFromID(unequippedID)).applyEffector(new Stats());
            this.base_lifepoints -= Math.round(add.health * 1.5f);
            if(lifepoints > base_lifepoints) lifepoints = base_lifepoints;
        }
        return unequippedID;
    }

    // Inventory
    private Map<String,Integer> inventory = new HashMap<>();

    public void addItem(String itemId){addItem(itemId, 1);}
    public void addItem(String itemId, int amount){
        List<String> keys = new ArrayList<>(inventory.keySet());
        if(!keys.contains(itemId)) inventory.put(itemId, 0);
        inventory.put(itemId, inventory.get(itemId)+amount);
    }

    public void removeItem(String itemId) { removeItem(itemId, 1); }
    public void removeItem(String itemId, int amount){
        List<String> keys = new ArrayList<>(inventory.keySet());
        if(!keys.contains(itemId)) return;
        inventory.put(itemId, inventory.get(itemId)-amount);
        if(inventory.get(itemId)<=0) inventory.remove(itemId);
    }

    public boolean hasItem(String itemId){return hasItem(itemId, 1);}
    public boolean hasItem(String itemId, int amount){
        List<String> keys = new ArrayList<>(inventory.keySet());
        if(!keys.contains(itemId)) return false;
        return inventory.get(itemId) >= amount;
    }

    public Map<String, Integer> getInventory(){ return inventory; }

    public Item getItem(String itemId){
        if(!hasItem(itemId)) return null;
        return GlobalGameManager.getInstance().getItemFromID(itemId);
    }

    // Stats
    @Override
    public Stats getStats() {
        Stats stats = super.getStats();
        if(equipment_attack != null) stats = equipment_attack.applyEffector(stats);
        if(equipment_helmet != null) stats = equipment_helmet.applyEffector(stats);
        if(equipment_torso != null) stats = equipment_torso.applyEffector(stats);
        if(equipment_legs != null) stats = equipment_legs.applyEffector(stats);
        if(equipment_shoes != null) stats = equipment_shoes.applyEffector(stats);
        return stats;
    }

    // Damaging
    @Override
    public int getRawAttackDamage() {
        int damage = super.getRawAttackDamage();
        Stats sup = getStats();
        damage += sup.strength * 2;
        // damage += (new Random().nextInt(5)-1);
        return damage;
    }

    @Override
    public void damage(int raw_damage) {
        lifepoints -= raw_damage;
        if(lifepoints <= 0) { notify(IObserver.NotificationType.PLAYER_DEATH); notify(IObserver.NotificationType.PLAYER_DEATH); }
    }

    public boolean gainExperience(float xp){
        if(expreience+xp >= 150){
            level++;
            expreience = (expreience+xp)%150;
            notify(IObserver.NotificationType.PLAYER_LEVELUP);
            return true;
        }else{
            expreience += xp;
        }
        return false;
    }

    @Override
    public List<IAbility> getAbilities() {
        List<IAbility> abilities = super.getAbilities();
        if(equipment_attack != null && equipment_attack.getAbilities() != null && equipment_attack.getAbilities().size() > 0)
            for(IAbility a : equipment_attack.getAbilities()) if(!abilities.contains(a)) abilities.add(a);
        if(equipment_helmet != null && equipment_helmet.getAbilities() != null && equipment_helmet.getAbilities().size() > 0)
            for(IAbility a : equipment_helmet.getAbilities()) if(!abilities.contains(a)) abilities.add(a);
        if(equipment_torso != null && equipment_torso.getAbilities() != null && equipment_torso.getAbilities().size() > 0)
            for(IAbility a : equipment_torso.getAbilities()) if(!abilities.contains(a)) abilities.add(a);
        if(equipment_legs != null && equipment_legs.getAbilities() != null && equipment_legs.getAbilities().size() > 0)
            for(IAbility a : equipment_legs.getAbilities()) if(!abilities.contains(a)) abilities.add(a);
        if(equipment_shoes != null && equipment_shoes.getAbilities() != null && equipment_shoes.getAbilities().size() > 0)
            for(IAbility a : equipment_shoes.getAbilities()) if(!abilities.contains(a)) abilities.add(a);
        return abilities;
    }
}
