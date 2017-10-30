package gameResources;

import database.fileStructure.PathMaster;
import database.serialization.Serializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResourceLoader {
    private static final String SKILLS = "skills.json";
    private static final String HINDRANCES = "hindrances.json";

    private static ResourceLoader SINGLETON = null;
    public static ResourceLoader get(){
        if(SINGLETON == null) SINGLETON = new ResourceLoader();
        return SINGLETON;
    }

    private ResourceLoader(){}

    public SkillJson loadSkills(){
        try{
            FileReader reader = new FileReader(new File(PathMaster.getResourceRoot() + SKILLS));
            return (SkillJson)Serializer.get().deserialize(reader, SkillJson.class);
        }catch(IOException e){
            return null;
        }
    }

    public HindranceJson loadHindrances(){
        try{
            FileReader reader = new FileReader(new File(PathMaster.getResourceRoot() + HINDRANCES));
            return (HindranceJson)Serializer.get().deserialize(reader, HindranceJson.class);
        }catch(IOException e){
            return null;
        }
    }
}
