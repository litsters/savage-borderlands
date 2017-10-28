package persistence;

import command.CommandData;
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
        File persistenceFile = new File(PathMaster.getPersistenceRoot() + GAME_FILENAME);
        if(!persistenceFile.exists()) return;
        try{
            FileReader reader = new FileReader(persistenceFile);
            Game loadedGame = (Game)Serializer.get().deserialize(reader, Game.class);
            reader.close();
            Game.get().loadGame(loadedGame);


        }catch(IOException e){
            e.printStackTrace();
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
            Game loadedGame = (Game)Serializer.get().deserialize(reader, Game.class);
            reader.close();
            Game.get().loadGame(loadedGame);


        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
