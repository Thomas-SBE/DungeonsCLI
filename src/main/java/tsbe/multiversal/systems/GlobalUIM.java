package tsbe.multiversal.systems;

import tsbe.multiversal.common.Constants;
import tsbe.multiversal.common.Stats;
import tsbe.multiversal.entity.classes.EC_Assassins;
import tsbe.multiversal.entity.classes.EC_Base;
import tsbe.multiversal.entity.classes.EC_Godlike;
import tsbe.multiversal.entity.common.Entity;
import tsbe.multiversal.entity.common.Player;
import tsbe.multiversal.dungeon.common.Dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GlobalUIM {

    // Singleton
    private static GlobalUIM INSTANCE = null;
    public static GlobalUIM getInstance(){ if(INSTANCE == null){INSTANCE = new GlobalUIM();} return INSTANCE; }

    private Scanner scanner;

    public GlobalUIM(){
        scanner = new Scanner(System.in);
    }

    public String askInput(String text){ return askInput(text, Constants.ASKER_PREFIX); }
    public String askInput(String text, String prefix){
        System.out.println(text);
        System.out.print(prefix);
        return scanner.nextLine();
    }

    public String askInlineInput(String text){ return askInlineInput(text, Constants.ASKER_PREFIX); }
    public String askInlineInput(String text, String prefix) {
        System.out.print(text);
        System.out.print(prefix);
        return scanner.nextLine();
    }

    public String progressBar(String pcolor, String scolor, float alpha, int size){
        String res = scolor + "[" + pcolor;
        res += "=".repeat(Math.round(size*alpha));
        res += " ".repeat(Math.round(size*(1-alpha)));
        res += scolor + "]" + Constants.SCOLOR_RESET;
        return res;
    }

    public String centeredText(String text, int size, String fill, int unaccounted_chars){ return centeredText(text, size+unaccounted_chars, fill); }
    public String centeredText(String text, int size, String fill){
        int side_amount = Math.abs(size-text.length());
        return fill.repeat(side_amount/(2*fill.length())) + text + fill.repeat(side_amount%2==0?side_amount/(2*fill.length()):side_amount/(2*fill.length())+1);
    }

    public String filledText(String text, int size, String fill, int uncaccounted_chars) { return filledText(text, size+uncaccounted_chars, fill); }
    public String filledText(String text, int size, String fill){
        return text + fill.repeat(Math.abs(size-text.length()));
    }

    public void displayClassList(){
        System.out.println();
        System.out.println(Constants.SCOLOR_BRIGHT + centeredText(" Classes disponibles ", 80, "=") + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_BLUE + "• " + new EC_Base().getName() + Constants.SCOLOR_RESET + Constants.SCOLOR_WHITE + " : " + new EC_Base().getDescription());
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_BLUE + "• " + new EC_Assassins().getName() + Constants.SCOLOR_RESET + Constants.SCOLOR_WHITE + " : " + new EC_Assassins().getDescription());
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_BLUE + "• " + new EC_Godlike().getName() + Constants.SCOLOR_RESET + Constants.SCOLOR_WHITE + " : " + new EC_Godlike().getDescription());
        // ADD CLASSES DISPLAY HERE
        System.out.println(Constants.SCOLOR_RESET);
    }

    public void displayInventory(Player p){
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + centeredText(" Inventaire & Statistiques ", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText(String.format("[ "+Constants.SCOLOR_YELLOW+"%s"+Constants.SCOLOR_RESET+Constants.SCOLOR_BRIGHT+Constants.SCOLOR_WHITE+" - "+Constants.SCOLOR_BLUE+"%s"+Constants.SCOLOR_RESET+Constants.SCOLOR_BRIGHT+Constants.SCOLOR_WHITE+" - "+Constants.SCOLOR_RESET+Constants.SCOLOR_RED+"%d"+Constants.SCOLOR_RESET+Constants.SCOLOR_WHITE+"/%d HP ]"+Constants.SCOLOR_BRIGHT, p.name, p.entityClass.getName(), p.lifepoints, p.base_lifepoints), 78, " ", 58) + "│" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "├" + "─".repeat(78) + "┤");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText(Constants.SCOLOR_UNDERLINE + "Equipement" + Constants.SCOLOR_RESET + Constants.SCOLOR_WHITE, 78, " ", 13) + "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + filledText(" [%s%s%s]%s".formatted(Constants.SCOLOR_CYAN, "A", Constants.SCOLOR_WHITE, Constants.SCOLOR_RESET) + Constants.SCOLOR_MAGENTA + " - En main : " + Constants.SCOLOR_RESET + (p.equipment_attack != null? p.equipment_attack.getName() : "Rien") + " " + Constants.SCOLOR_WHITE, 78, " ", 28) + Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT+ "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + filledText(" [%s%s%s]%s".formatted(Constants.SCOLOR_CYAN, "H", Constants.SCOLOR_WHITE, Constants.SCOLOR_RESET) + Constants.SCOLOR_MAGENTA + " - Casque : " + Constants.SCOLOR_RESET + (p.equipment_helmet != null? p.equipment_helmet.getName() : "Rien") + " " + Constants.SCOLOR_WHITE, 78, " ", 28) + Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT+ "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + filledText(" [%s%s%s]%s".formatted(Constants.SCOLOR_CYAN, "T", Constants.SCOLOR_WHITE, Constants.SCOLOR_RESET) + Constants.SCOLOR_MAGENTA + " - Plastron : " + Constants.SCOLOR_RESET + (p.equipment_torso != null? p.equipment_torso.getName() : "Rien") + " " + Constants.SCOLOR_WHITE, 78, " ", 28) + Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT+ "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + filledText(" [%s%s%s]%s".formatted(Constants.SCOLOR_CYAN, "L", Constants.SCOLOR_WHITE, Constants.SCOLOR_RESET) + Constants.SCOLOR_MAGENTA + " - Pantalon : " + Constants.SCOLOR_RESET + (p.equipment_legs != null? p.equipment_legs.getName() : "Rien") + " " + Constants.SCOLOR_WHITE, 78, " ", 28) + Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT+ "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + filledText(" [%s%s%s]%s".formatted(Constants.SCOLOR_CYAN, "S", Constants.SCOLOR_WHITE, Constants.SCOLOR_RESET) + Constants.SCOLOR_MAGENTA + " - Chaussures : " + Constants.SCOLOR_RESET + (p.equipment_shoes != null? p.equipment_shoes.getName() : "Rien") + " " + Constants.SCOLOR_WHITE, 78, " ", 28) + Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT+ "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "├" + "─".repeat(78/2) + "┬" + "─".repeat(78/2-1) + "┤");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText(String.format(Constants.SCOLOR_RESET+Constants.SCOLOR_YELLOW+"Credits : %d aUEC"+Constants.SCOLOR_RESET, p.money), 78/2, " ", 13)+Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText(String.format(Constants.SCOLOR_RESET+Constants.SCOLOR_GREEN+"Niveau %d "+Constants.SCOLOR_WHITE+": %.1f / %.1f EXP"+Constants.SCOLOR_RESET, p.level, p.expreience, 150.0f), 78/2-1, " ", 18)+Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "├" + "─".repeat(78/2) + "┼" + "─".repeat(78/2-1) + "┤");
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText(Constants.SCOLOR_UNDERLINE + "Inventaire" + Constants.SCOLOR_RESET+Constants.SCOLOR_WHITE,78/2, " ", 13) + "│" + centeredText(Constants.SCOLOR_UNDERLINE + "Statistiques" + Constants.SCOLOR_RESET+Constants.SCOLOR_WHITE,78/2-1, " ", 13) + "│");
        List<String> itemKeys = new ArrayList<>(p.getInventory().keySet());
        Stats stats = p.getStats();
        for(int i = 0; i < Math.max(3, itemKeys.size()); i++){
            String line = Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + (i>=itemKeys.size() ? centeredText("", 78/2, " ") : filledText(" [%s%d%s]".formatted(Constants.SCOLOR_CYAN, i, Constants.SCOLOR_WHITE) + Constants.SCOLOR_RESET+ " "+p.getItem(itemKeys.get(i)).getName()+ Constants.SCOLOR_WHITE + " x"+p.getInventory().get(itemKeys.get(i)), 78/2, " ", 19)) + Constants.SCOLOR_WHITE + Constants.SCOLOR_BRIGHT + "│";
            switch (i){
                case 0 -> line += filledText(Constants.SCOLOR_RESET + " • " + "Santé : " + (stats.health>0?Constants.SCOLOR_GREEN:(stats.health==0?Constants.SCOLOR_WHITE:Constants.SCOLOR_RED)) + stats.health, 78/2-1, " ", 9) + Constants.SCOLOR_WHITE + Constants.SCOLOR_BRIGHT + "│";
                case 1 -> line += filledText(Constants.SCOLOR_RESET + " • " + "Force : " + (stats.strength>0?Constants.SCOLOR_GREEN:(stats.strength==0?Constants.SCOLOR_WHITE:Constants.SCOLOR_RED)) + stats.strength, 78/2-1, " ", 9) + Constants.SCOLOR_WHITE + Constants.SCOLOR_BRIGHT + "│";
                case 2 -> line += filledText(Constants.SCOLOR_RESET + " • " + "Chance : " + (stats.luck>0?Constants.SCOLOR_GREEN:(stats.luck==0?Constants.SCOLOR_WHITE:Constants.SCOLOR_RED)) + stats.luck, 78/2-1, " ", 9) + Constants.SCOLOR_WHITE + Constants.SCOLOR_BRIGHT + "│";
                default -> line += filledText("", 78/2-1, " ") + "│";
            }
            System.out.println(line);
        }
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "├" + "─".repeat(78/2) + "┴" + "─".repeat(78/2-1) + "┤" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText("%sA tout moment, pour voir les commandes, tapez%s help%s".formatted(Constants.SCOLOR_WHITE, Constants.SCOLOR_GREEN, Constants.SCOLOR_WHITE), 78, " ", 15) + "│" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);
    }

    public void displayDungeonEntering(Dungeon dungeon, int current_room_num){
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + centeredText(" Vous entrez dans : ", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + Constants.SCOLOR_MAGENTA + centeredText(dungeon.getName() + ", Salle %d".formatted(current_room_num), 78, " ") + Constants.SCOLOR_WHITE + "│" + Constants.SCOLOR_RESET);
        String rout = (dungeon.canExitAt(current_room_num)? Constants.SCOLOR_YELLOW+"Vous pouvez sortir a l'issue de cette salle"+Constants.SCOLOR_WHITE : Constants.SCOLOR_WHITE+"Vous ne pourrez pas sortir a l'issue de cette salle"+Constants.SCOLOR_WHITE );
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText(rout, 78, " ", 10) + "│" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);

    }

    public void displayMainMenu(List<Dungeon> available_dungeons){
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + centeredText(" Menu principal ", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│ " + filledText(Constants.SCOLOR_UNDERLINE+"Informations :"+ Constants.SCOLOR_RESET, 78/2-1, " ", 8) + Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│ " + filledText(Constants.SCOLOR_UNDERLINE + "Donjons accessibles :" + Constants.SCOLOR_RESET, 78/2-2, " ", 8) + Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + Constants.SCOLOR_RESET);
        for(int i = 0; i < Math.max(4, available_dungeons.size()); i++){
            String dungeon = filledText("", 78/2-2, " ");;
            String cmds = filledText("", 78/2-1, " ");
            if(i < available_dungeons.size()) dungeon = " " + filledText("[%s%d%s]%s • %s%s".formatted(Constants.SCOLOR_GREEN, i, Constants.SCOLOR_WHITE, Constants.SCOLOR_RESET, available_dungeons.get(i).getName(), Constants.SCOLOR_BRIGHT+Constants.SCOLOR_WHITE),78/2-3, " ", 23);
            switch (i){
                case 1 -> {cmds = " " + filledText(Constants.SCOLOR_YELLOW + "• Obtenir de l'aide :" + Constants.SCOLOR_WHITE, 78/2-2, " ", 10);}
                case 2 -> {cmds = " " + filledText(Constants.SCOLOR_RESET+Constants.SCOLOR_WHITE + "   La commande "+Constants.SCOLOR_GREEN+"help"+Constants.SCOLOR_WHITE + Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE, 78/2-2, " ", 28);}
                case 0 -> {cmds = " " + filledText(Constants.SCOLOR_YELLOW + "" + Constants.SCOLOR_WHITE, 78/2-2, " ", 10);}
                case 3 -> {cmds = " " + filledText(Constants.SCOLOR_RESET+Constants.SCOLOR_WHITE + "" + Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE, 78/2-2, " ", 18);}
            }
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│ " + cmds + "│ " + dungeon + "│" + Constants.SCOLOR_RESET);
        }
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);

    }

    public void displayRoomState(List<Entity> allies, List<Entity> enemies){
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "┌" + centeredText("", 78, "─") + "┐" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + centeredText("Votre santé : %d %s%s %d HP".formatted(GlobalGameManager.getInstance().player.lifepoints, progressBar(Constants.SCOLOR_RED+Constants.SCOLOR_BRIGHT, Constants.SCOLOR_WHITE+Constants.SCOLOR_BRIGHT, (float)(GlobalGameManager.getInstance().player.lifepoints)/(float)(GlobalGameManager.getInstance().player.base_lifepoints), 40), Constants.SCOLOR_BRIGHT+Constants.SCOLOR_WHITE, GlobalGameManager.getInstance().player.base_lifepoints), 78, " ", 40) + "│" + Constants.SCOLOR_RESET);
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "├" + centeredText("", 78, "─") + "┤" + Constants.SCOLOR_RESET);
        if(allies.size() > 0){
            for (Entity ally : allies) {
                System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + filledText("%s • %s %s[%s%d%s/%dHP] ".formatted(Constants.SCOLOR_GREEN, ally.name, Constants.SCOLOR_WHITE, Constants.SCOLOR_RED, ally.lifepoints, Constants.SCOLOR_WHITE, ally.base_lifepoints), 78, " ", 20) + Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│");
            }
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "├" + centeredText("", 78, "─") + "┤" + Constants.SCOLOR_RESET);
        }
        for(int i = 0; i < enemies.size(); i++){
            System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│" + filledText(" [%s%d%s] %s• %s %s[%s%d%s/%dHP]".formatted(Constants.SCOLOR_YELLOW,i,Constants.SCOLOR_WHITE,Constants.SCOLOR_RED,enemies.get(i).name,Constants.SCOLOR_WHITE,Constants.SCOLOR_RED,enemies.get(i).lifepoints,Constants.SCOLOR_WHITE,enemies.get(i).base_lifepoints), 78, " ", 30) + Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "│");
        }
        System.out.println(Constants.SCOLOR_BRIGHT + Constants.SCOLOR_WHITE + "└" + "─".repeat(78) + "┘" + Constants.SCOLOR_RESET);
    }

}
