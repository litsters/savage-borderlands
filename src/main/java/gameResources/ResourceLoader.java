package gameResources;

import database.fileStructure.PathMaster;
import database.serialization.Serializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResourceLoader {
    private static final String SKILLS = "skills.json";
    private static final String HINDRANCES = "hindrances.json";
    private static final String POWERS = "powers.json";
    private static final String EDGES = "edges.json";

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

    public EdgesJson loadEdges(){
        try{
            FileReader reader = new FileReader(new File(PathMaster.getResourceRoot() + EDGES));
            return (EdgesJson)Serializer.get().deserialize(reader, EdgesJson.class);
        }catch(IOException e){
            return null;
        }
    }

    public PowersJson loadPowers(){
        try{
            FileReader reader = new FileReader(new File(PathMaster.getResourceRoot() + POWERS));
            return (PowersJson)Serializer.get().deserialize(reader, PowersJson.class);
        }catch(IOException e){
            return null;
        }
    }
}
