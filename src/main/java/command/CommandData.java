package command;

import java.util.HashMap;

public class CommandData {
    private CommandType type;
    private HashMap<String, String> stringValues;

    public CommandData(CommandType type){
        this.type = type;
        this.stringValues = new HashMap<>();
    }

    public CommandType getType() {
        return type;
    }

    public String getValue(String key) throws MissingFieldException{
        String value = stringValues.get(key);
        if(value == null) throw new MissingFieldException("Missing field " + key);
        else return value;
    }
}
