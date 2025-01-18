package romantointeger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    private final RomanToInteger converter = new RomanToInteger();

    @Test
    void testSingleCharacter() {
        assertEquals(1, converter.romanToInt("I"));
        assertEquals(5, converter.romanToInt("V"));
        assertEquals(10, converter.romanToInt("X"));
        assertEquals(50, converter.romanToInt("L"));
        assertEquals(100, converter.romanToInt("C"));
        assertEquals(500, converter.romanToInt("D"));
        assertEquals(1000, converter.romanToInt("M"));
    }

    @Test
    void testBasicNumerals() {
        assertEquals(3, converter.romanToInt("III"));
        assertEquals(4, converter.romanToInt("IV"));
        assertEquals(9, converter.romanToInt("IX"));
        assertEquals(58, converter.romanToInt("LVIII")); // 50 + 5 + 3
        assertEquals(1994, converter.romanToInt("MCMXCIV")); // 1000 + 900 + 90 + 4
        assertEquals(1695, converter.romanToInt("MDCXCV")); // 1000 + 500 + 100 + 90 + 5
    }

    @Test
    void testSubtractiveCombinations() {
        assertEquals(20, converter.romanToInt("XX"));
        assertEquals(40, converter.romanToInt("XL"));
        assertEquals(90, converter.romanToInt("XC"));
        assertEquals(400, converter.romanToInt("CD"));
        assertEquals(900, converter.romanToInt("CM"));
    }

    @Test
    void testComplexCombinations() {
        assertEquals(491, converter.romanToInt("CDXCI"));
        assertEquals(3888, converter.romanToInt("MMMDCCCLXXXVIII"));
        assertEquals(2763, converter.romanToInt("MMDCCLXIII"));
        assertEquals(44, converter.romanToInt("XLIV"));
        assertEquals(3999, converter.romanToInt("MMMCMXCIX"));
    }
}

