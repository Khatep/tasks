package palindromenumber;

/**
 * Leetcode 9. Given an integer x, return true if x is a palindrome, and false otherwise.
 * */

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean b = palindromeNumber.isPalindrome(1001);
        System.out.println(b);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }

        String s = String.valueOf(x);
        boolean isPalindrome = true;
        int endPointer = s.length() - 1;
        for (int startPointer = 0; startPointer <= s.length() / 2 - 1; startPointer++) {
            if (s.charAt(startPointer) != s.charAt(endPointer)) {
                isPalindrome = false;
                break;
            }
            endPointer--;
        }
        return isPalindrome;
    }
}
