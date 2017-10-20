package model.character;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    @Test
    public void validNameTest() throws Exception{
        String[] testCases = new String[]{
                "a",
                "ab",
                "1234567890123456789012345678901",
                "12345678901234567890123456789012",
                "a a",
                "a a a",
                "12345678901234567890123456789012 ",
                "-",
                "'"
        };
        for(String test : testCases){
            CharacterName name = new CharacterName(test);
        }
    }

    @Test
    public void invalidNameTest() throws Exception{
        String[] testCases = new String[]{
                null,
                "",
                "123456789012345678901234567890123",
                "!",
                "@",
                "#",
                "$",
                "%",
                "^",
                "&",
                "*",
                "(",
                ")",
                "+",
                "="
        };
        for(String test : testCases){
            try{
                CharacterName name = new CharacterName(test);
                fail();
            }catch(InvalidInputException e){

            }
        }
    }
}