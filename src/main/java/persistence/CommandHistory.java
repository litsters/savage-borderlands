package persistence;

import command.CommandData;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<CommandData> commands;

    public CommandHistory(){
        this.commands = new ArrayList<>();
    }

    public void addCommand(CommandData commandData){
        commands.add(commandData);
    }

    public List<CommandData> getCommands(){ return commands;}

    public int numCommands(){ return commands.size();}
}
