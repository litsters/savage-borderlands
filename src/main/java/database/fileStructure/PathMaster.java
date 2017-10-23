package database.fileStructure;

public class PathMaster {
    private static final String PLAYER_ACCOUNT_ROOT = "server/database/playerAccounts/";
    private static final String GM_ACCOUNT_ROOT = "server/database/gmAccounts/";
    private static final String HTML_ROOT = "server/site/";
    private static final String PORTRAIT_ROOT = "server/site/res/portraits/";

    private PathMaster(){}

    public static String getPlayerAccountRoot() {
        return PLAYER_ACCOUNT_ROOT;
    }

    public static String getGmAccountRoot() {
        return GM_ACCOUNT_ROOT;
    }

    public static String getHtmlRoot() {
        return HTML_ROOT;
    }

    public static String getPortraitRoot() {
        return PORTRAIT_ROOT;
    }
}
