package database.dao;

import com.google.gson.JsonSyntaxException;
import database.fileStructure.PathMaster;
import database.serialization.Serializer;
import model.player.Player;

import java.io.*;
import java.nio.file.NoSuchFileException;

public class PlayerDao {
    private static PlayerDao SINGLETON = null;
    private static String PLAYER_FILE = "player.json";
    public static String RESERVED_FOR_TESTING = "testUsername";

    public static PlayerDao get(){
        if(SINGLETON == null) SINGLETON = new PlayerDao();
        return SINGLETON;
    }

    private PlayerDao(){}

    public Player getPlayer(String username) throws NoSuchPlayerException{
        File playerDirectory = getPlayerDirectory(username);
        if(playerDirectory == null) throw new NoSuchPlayerException("Player " + username + " has no account on file");
        File playerFile = new File(PathMaster.getPlayerAccountRoot() + username + "/" + PLAYER_FILE);
        if(!playerFile.exists() || !playerFile.isFile()){
            throw new NoSuchPlayerException("Player " + username + " has no data");
        }
        try{
            FileReader reader = new FileReader(playerFile);
            Player player = (Player)Serializer.get().deserialize(reader, Player.class);
            try{
                reader.close();
            }catch(IOException e){
                System.err.println("Encountered error while closing file: " + playerFile);
            }
            if(player == null) throw new NoSuchPlayerException("Data for " + username + " is unreadable");
            else return player;
        }catch(FileNotFoundException e){
            throw new NoSuchPlayerException("Player " + username + " has no data");
        }catch(JsonSyntaxException e){
            throw new NoSuchPlayerException("Data for " + username + " is unreadable");
        }
    }

    public void savePlayer(Player player) throws FailedSaveException{
        String username = player.getUsername().getValue();
        // Get the directory for the player
        File playerDirectory = getPlayerDirectory(username);
        if(playerDirectory == null){
            // Create the directory since it doesn't already exist
            boolean success = createDirectoryWithName(username);
            if(!success) throw new FailedSaveException("Couldn't find or create directory for " + username);
        }
        // Delete the old file
        File oldFile = getPlayerFile(username);
        if(oldFile != null){
            try{
                deleteFile(oldFile);
            }catch(NoSuchFileException e){
                System.err.println("File " + oldFile + " was initially found, but couldn't be found later");
            }
        }
        // Create the new file
        File newPlayerFile = new File(PathMaster.getPlayerAccountRoot() + username + "/" + PLAYER_FILE);
        try{
            FileWriter writer = new FileWriter(newPlayerFile);
            Serializer.get().serialize(player, writer);
            writer.close();
        }catch(IOException e){
            throw new FailedSaveException("Couldn't write to the new file");
        }
    }

    private File getPlayerDirectory(String username){
        File playerDirectory = new File(PathMaster.getPlayerAccountRoot() + username);
        if(!playerDirectory.exists() || !playerDirectory.isDirectory()) return null;
        else return playerDirectory;
    }

    private File getPlayerFile(String username){
        File playerFile = new File(PathMaster.getPlayerAccountRoot() + username + "/" + PLAYER_FILE);
        if(!playerFile.exists() || !playerFile.isFile()) return null;
        else return playerFile;
    }

    private boolean createDirectoryWithName(String username){
        File newDirectory = new File(PathMaster.getPlayerAccountRoot() + username);
        return newDirectory.mkdir();
    }

    private boolean deleteFile(File targetFile) throws NoSuchFileException{
        if(!targetFile.exists() || !targetFile.isFile()) throw new NoSuchFileException(targetFile + " does not exist");
        return targetFile.delete();
    }
}
