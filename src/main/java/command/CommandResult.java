package command;

import java.util.HashMap;
import java.util.Map;

public class CommandResult {
    private Map<String, Object> values;

    public CommandResult(){
        values = new HashMap<>();
    }

    public void addValue(String key, Object value){
        values.put(key, value);
    }
}
