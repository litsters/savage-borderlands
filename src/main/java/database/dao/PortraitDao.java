package database.dao;

import database.fileStructure.PathMaster;

import java.io.File;

public class PortraitDao {
    private static PortraitDao SINGLETON = null;
    public static PortraitDao get(){
        if(SINGLETON == null) SINGLETON = new PortraitDao();
        return SINGLETON;
    }
    private PortraitDao(){}

    public String[] getPortraits(){
        File portraitDirectory = new File(PathMaster.getPortraitRoot());
        return portraitDirectory.list();
    }
}
