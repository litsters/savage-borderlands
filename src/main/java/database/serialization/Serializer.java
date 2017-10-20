package database.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.Reader;

public class Serializer {
    private static Serializer SINGLETON = null;

    private Gson gson;

    public static Serializer get() {
        if(SINGLETON == null) SINGLETON = new Serializer();
        return SINGLETON;
    }

    private Serializer() {
        gson = new Gson();
    }

    public void serialize(Object object, Appendable appendable){
        gson.toJson(object, appendable);
    }

    public Object deserialize(Reader reader, Class klass)throws JsonSyntaxException{
        Object obj = gson.fromJson(reader, klass);
        return obj;
    }
}
