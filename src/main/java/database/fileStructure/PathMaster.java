package database.fileStructure;

public class PathMaster {
    private static final String HTML_ROOT = "server/site/";
    private static final String PORTRAIT_ROOT = "server/site/res/portraits/";
    private static final String PERSISTENCE_ROOT = "server/database/";
    private static final String RESOURCE_ROOT = "src/main/java/gameResources/";

    private PathMaster(){}

    public static String getHtmlRoot() {
        return HTML_ROOT;
    }

    public static String getPortraitRoot() {
        return PORTRAIT_ROOT;
    }

    public static String getPersistenceRoot() {
        return PERSISTENCE_ROOT;
    }

    public static String getResourceRoot() {
        return RESOURCE_ROOT;
    }
}
