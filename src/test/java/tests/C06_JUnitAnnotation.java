package tests;

import org.junit.jupiter.api.*;

public class C06_JUnitAnnotation {

    @BeforeAll
     static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void BeforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
    void AfterEach() {
        System.out.println("After Each");
    }

    @Test
     void test01() {
        System.out.println("Test01");
    }

    @Test
    void test02() {
        System.out.println("Test02");
    }

    @Test @Disabled
    void test03() {
        System.out.println("Test03");
    }

    @Test
    void test04() {
        System.out.println("Test04");
    }

    @Test // @DisplayName("This is Test05")
    void test05() {
        System.out.println("Test05");
    }

}
