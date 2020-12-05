package exercicios.ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestValores {

    Valores classUnderTest;
    Random rnd = new SecureRandom();

    @BeforeEach
    void setupAll() {
        classUnderTest = new Valores();
    }

    @Test
    void test_WhenInsertingTenPositiveInts_ThenSizeMustBeTen() {
        for (int i = 0; i < 10; i++) {
            int v = rnd.nextInt();
            classUnderTest.ins(v > 0 ? v : -v);
        }

        assertEquals(10, classUnderTest.size());
    }

    @Test
    void test_WhenTryingToInsertingTenNegativeInts_ThenSizeMustBeZeroForEachTry() {
        for (int i = 0; i < 10; i++) {
            int v = rnd.nextInt();
            classUnderTest.ins(v > 0 ? -v : v);
            assertEquals(0, classUnderTest.size());
        }
    }

    @Test
    void test_WhenInsertedTenPositiveInts_AndRemoveThreeOfThem_ThenSizeMustBeSeven() {
        for (int i = 0; i < 10; i++) {
            int v = rnd.nextInt();
            classUnderTest.ins(v > 0 ? v : -v);
        }
        for (int i = 0; i < 5; i += 2)
            classUnderTest.del(i);

        assertEquals(7, classUnderTest.size());
    }

    @Test
    void test_WhenListIsEmpty_ThenSizeMustBeZero() {
        assertEquals(0, classUnderTest.size());
    }

    @Test
    void test_WhenListIsEmpty_ThenDelMustReturnMinusOne() {
        assertEquals(-1, classUnderTest.del(1));
    }

}