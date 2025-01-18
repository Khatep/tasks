package romantointeger;

import java.util.Map;

/**
 * Leetcode 13. Converts a Roman numeral string into an integer.
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D, and M.
 * <ul>
 *   <li>Symbol       Value</li>
 *   <li>I             1</li>
 *   <li>V             5</li>
 *   <li>X             10</li>
 *   <li>L             50</li>
 *   <li>C             100</li>
 *   <li>D             500</li>
 *   <li>M             1000</li>
 * </ul>
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written from largest to smallest from left to right.
 * However, there are six instances where subtraction is used:
 * <ul>
 *   <li>I can be placed before V (5) and X (10) to make 4 and 9.</li>
 *   <li>X can be placed before L (50) and C (100) to make 40 and 90.</li>
 *   <li>C can be placed before D (500) and M (1000) to make 400 and 900.</li>
 * </ul>
 * Given a Roman numeral, this method converts it to an integer.
 *
 * @param s the Roman numeral string to convert
 * @return the integer value of the Roman numeral
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToIntFastest("VII"));
    }

    public int romanToInt(String s) {
        final Map<Character, Integer> romanSymbolsAndIntegers = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        if (s.length() == 1)
            return romanSymbolsAndIntegers.get(s.charAt(0));

        /*
         An element is considered composite if the previous element is smaller than it.

         Examples:
         IV -> V is composite because I is smaller than V.
         XV -> V is uncomposite because X is greater than V.
        */
        boolean isPreviousElementComposite = false;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (isPreviousElementComposite)
                i++;

            //if iterator == last element
            if (i == s.length())
                return result + romanSymbolsAndIntegers.get(s.charAt(i - 1));

            int previousElement = romanSymbolsAndIntegers.get(s.charAt(i - 1));
            int currentElement = romanSymbolsAndIntegers.get(s.charAt(i));

            if (previousElement < currentElement) {
                result += currentElement - previousElement;
                isPreviousElementComposite = true;
            } else {
                result += previousElement;
                isPreviousElementComposite = false;
            }
        }

        //After loop -> current element == last element
        if (!isPreviousElementComposite)
            result += romanSymbolsAndIntegers.get(s.charAt(s.length() - 1));

        return result;
    }


    public static int romanToIntFastest(String s) {
        final Map<Character, Integer> romanSymbolsAndIntegers = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        // VII
        //1 -> ind = 2, curr = 1, prev = 0, res = 1
        //2 -> ind = 1, curr = 1, prev = 1, res = 2
        //3 -> ind = 0, curr = 5, prev = 1, res = 7

        //IV
        //1 -> ind = 1, curr = 5, prev = 0, res = 5
        //2 -> ind = 0, curr = 1, prev = 5, res = 4
        int result = 0, currentElement, previousElement = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            currentElement = romanSymbolsAndIntegers.get(s.charAt(i));
            if (currentElement < previousElement) {
                result -= currentElement;
            } else {
                result += currentElement;
            }
            previousElement = currentElement;
        }
        return result;
    }
}


