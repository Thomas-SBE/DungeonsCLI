package tsbe.multiversal.common;

public class Constants {

    // COLORS
    public static String SCOLOR_RESET = "\u001b[0m";
    public static String SCOLOR_BLACK = "\u001b[30m";
    public static String SCOLOR_RED = "\u001b[31m";
    public static String SCOLOR_GREEN = "\u001b[32m";
    public static String SCOLOR_YELLOW = "\u001b[33m";
    public static String SCOLOR_BLUE = "\u001b[34m";
    public static String SCOLOR_MAGENTA = "\u001b[35m";
    public static String SCOLOR_CYAN = "\u001b[36m";
    public static String SCOLOR_WHITE = "\u001b[37m";
    public static String SCOLOR_BRIGHT = "\u001b[1m";
    public static String SCOLOR_UNDERLINE = "\u001b[4m";
    public static String SCOLOR_REVERSED = "\u001b[7m";

    public static String SPACER = SCOLOR_BRIGHT + SCOLOR_WHITE + "│" + SCOLOR_RESET;

    public static String ASK_NAME_STRING = SCOLOR_BRIGHT + SCOLOR_YELLOW + "Quel est votre nom aventurier %s?" + SCOLOR_RESET;
    public static String ASK_CLASS_STRING = SCOLOR_BRIGHT + SCOLOR_YELLOW + "Quel est votre classe aventurier %s?" + SCOLOR_RESET + SCOLOR_WHITE + " (Tapez le nom de la classe)" + SCOLOR_RESET;
    public static String ASK_NEXT_MOVE = SCOLOR_BRIGHT + SCOLOR_YELLOW + "Que faire ?" + SCOLOR_RESET;
    public static String ASK_EXIT_DUNGEON = SCOLOR_BRIGHT + SCOLOR_YELLOW + "Voulez-vous quitter le donjon maintenant ? " + SCOLOR_RESET + SCOLOR_WHITE + "( o/oui | n/non )" + SCOLOR_RESET;

    public static String ASKER_PREFIX = SCOLOR_BRIGHT + SCOLOR_WHITE + " +-→ " + SCOLOR_RESET;


}
