package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class C07_Assertions {

    String name;

    @Test
    void assertEqualsTest() {

        String actualData = "Yaser";
        String expectedData = "Yaser";
        Assertions.assertEquals(expectedData, actualData, "Names did not match!");

    }

    @Test
    void assertTrueTest(){

        String table = """
                First Name: Yaser
                Last Name: Alshammari
                
                """;
        Assertions.assertTrue(table.contains("Yaser"), "Table does not contain yaser");

    }

    @Test
    void assertFalseTest(){

        String table = """
                First Name: Yaser
                Last Name: Alshammari
                """;
        Assertions.assertFalse(table.contains("y4ser"), "Table contains y4ser");

    }

    @Test
    void assertNullTest(){
//        name = "A";
        assertNull(name, "Name is not null");
    }

}
