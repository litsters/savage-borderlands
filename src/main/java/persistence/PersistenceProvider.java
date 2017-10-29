package persistence;

import command.*;
import database.fileStructure.PathMaster;
import database.serialization.Serializer;
import model.game.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceProvider {
    private static final int DEFAULT_SAVE_FREQUENCY = 10;
    private static final String GAME_FILENAME = "game.json";
    private static final String COMMAND_HISTORY_FILENAME = "commands.json";

    private static PersistenceProvider SINGLETON = null;
    public static PersistenceProvider get(){
        if(SINGLETON == null) SINGLETON = new PersistenceProvider();
        return SINGLETON;
    }

    private int saveFrequency;
    private CommandHistory commandHistory;

    private PersistenceProvider(){
        this.saveFrequency = DEFAULT_SAVE_FREQUENCY;
        commandHistory = new CommandHistory();
    }

    public int getSaveFrequency() {
        return saveFrequency;
    }

    public void setSaveFrequency(int saveFrequency) {
        this.saveFrequency = saveFrequency;
    }

    public void loadGame(){
        try{
            Game loadedGame = (Game)loadPersistedObject(GAME_FILENAME, Game.class);
            Game.get().loadGame(loadedGame);
            CommandHistory loadedHistory = (CommandHistory)loadPersistedObject(COMMAND_HISTORY_FILENAME, CommandHistory.class);
            if(loadedHistory != null){
                List<CommandData> commands = loadedHistory.getCommands();
                for(CommandData c : commands){
                    Command command = ServerCommandFactory.get().generateCommand(c);
                    command.execute();
                }
                this.commandHistory = loadedHistory;
            }
        }catch(MissingPersistedObjectException e){
            System.err.println("No saved game found.");
        }catch(NoSuchCommandException | MissingFieldException e){
            System.err.println("Unusable command during loading.");
        }
    }

    public void clearGame(){
        File persistenceFile = new File(PathMaster.getPersistenceRoot() + GAME_FILENAME);
        persistenceFile.delete();
        persistenceFile = new File(PathMaster.getPersistenceRoot() + COMMAND_HISTORY_FILENAME);
        persistenceFile.delete();
    }

    public void clearHistory(){
        File persistenceFile = new File(PathMaster.getPersistenceRoot() + COMMAND_HISTORY_FILENAME);
        persistenceFile.delete();
    }

    public void addCommand(CommandData commandData){
        commandHistory.addCommand(commandData);
        if(commandHistory.numCommands() >= saveFrequency){
            // Save game
            persistObject(GAME_FILENAME, Game.get());
            // Reset command history
            commandHistory = new CommandHistory();
        } else {
            // Save command history
            persistObject(COMMAND_HISTORY_FILENAME, commandHistory);
        }
    }

    private void persistObject(String filename, Object object){
        File persistenceFile = new File(PathMaster.getPersistenceRoot() + filename);
        persistenceFile.delete();
        try{
            FileWriter writer = new FileWriter(persistenceFile);
            Serializer.get().serialize(object, writer);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private Object loadPersistedObject(String filename, Class klass) throws MissingPersistedObjectException{
        File persistenceFile = new File(PathMaster.getPersistenceRoot() + filename);
        if(!persistenceFile.exists()) return null;
        try{
            FileReader reader = new FileReader(persistenceFile);
            Object loadedObject = Serializer.get().deserialize(reader, klass);
            reader.close();
            return loadedObject;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
