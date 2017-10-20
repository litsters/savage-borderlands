package database.dao;

import database.fileStructure.PathMaster;
import model.player.Password;
import model.player.Player;
import model.player.Username;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PlayerDaoTest {
    @Before
    public void setup(){
        File testDirectory = new File(PathMaster.getPlayerAccountRoot() + PlayerDao.RESERVED_FOR_TESTING);
        if(testDirectory.exists()) {
            String[]entries = testDirectory.list();
            for(String s: entries){
                File currentFile = new File(testDirectory.getPath(),s);
                currentFile.delete();
            }
            testDirectory.delete();
        }
    }

    @After
    public void teardown(){
        File testDirectory = new File(PathMaster.getPlayerAccountRoot() + PlayerDao.RESERVED_FOR_TESTING);
        if(testDirectory.exists()) {
            String[]entries = testDirectory.list();
            for(String s: entries){
                File currentFile = new File(testDirectory.getPath(),s);
                currentFile.delete();
            }
            testDirectory.delete();
        }
    }

    /**
     * This method relies on the savePlayer method to ensure correct testing.
     * @throws Exception If anything goes wrong
     */
    @Test
    public void getPlayer() throws Exception {
        Player test = new Player(new Username(PlayerDao.RESERVED_FOR_TESTING), new Password("password"));
        PlayerDao.get().savePlayer(test);

        Player player = PlayerDao.get().getPlayer(PlayerDao.RESERVED_FOR_TESTING);
        assertTrue(player != null);
        assertTrue(player.getUsername().getValue().matches(PlayerDao.RESERVED_FOR_TESTING));
        assertTrue(player.correctPassword("password"));
    }

    @Test
    public void savePlayer() throws Exception {
        Player test = new Player(new Username(PlayerDao.RESERVED_FOR_TESTING), new Password("password"));
        PlayerDao.get().savePlayer(test);
        File testFile = new File(PathMaster.getPlayerAccountRoot() + PlayerDao.RESERVED_FOR_TESTING + "/" + "player.json");
        assertTrue(testFile.exists());
        assertTrue(testFile.isFile());
    }

}