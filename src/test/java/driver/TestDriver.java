package driver;

public class TestDriver {
    public static void main(String[] args){
        org.junit.runner.JUnitCore.main(
                "model.character.NameTest",
                "database.dao.PlayerDaoTest"
        );
    }
}
