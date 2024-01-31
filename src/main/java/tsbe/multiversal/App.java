package tsbe.multiversal;

import tsbe.multiversal.dungeon.D_Terminator;
import tsbe.multiversal.items.*;
import tsbe.multiversal.systems.GameStateManager;
import tsbe.multiversal.systems.GlobalGameManager;
import tsbe.multiversal.dungeon.D_Proto;
import tsbe.multiversal.items.*;

public class App {

    public static void main(String[] args){
        GlobalGameManager.getInstance().registerItem(new Item_Fez());
        GlobalGameManager.getInstance().registerItem(new Item_SteveDiamond());
        GlobalGameManager.getInstance().registerItem(new Item_Slip());
        GlobalGameManager.getInstance().registerItem(new Item_PommeOr());
        GlobalGameManager.getInstance().registerItem(new Item_PotionXp());
        GlobalGameManager.getInstance().registerItem(new Item_AllMight());
        GlobalGameManager.getInstance().registerItem(new Item_MasqueFFPD());
        GlobalGameManager.getInstance().registerItem(new Item_CrystalShoes());
        GlobalGameManager.getInstance().registerItem(new Item_CrystalTorso());
        GlobalGameManager.getInstance().registerItem(new Item_HiddenBlade());
        GlobalGameManager.getInstance().registerItem(new Item_LaserBlade());
        GlobalGameManager.getInstance().registerItem(new Item_Mastercard());
        GlobalGameManager.getInstance().registerItem(new Item_Trefle());
        GlobalGameManager.getInstance().registerItem(new Item_WoodenSword());

        GlobalGameManager.getInstance().unlockDungeon(D_Proto.getInstance());
        GlobalGameManager.getInstance().unlockDungeon(D_Terminator.getInstance());

        GameStateManager.getInstance().initialize();



    }

}
