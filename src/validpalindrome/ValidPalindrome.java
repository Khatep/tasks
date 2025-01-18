package validpalindrome;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome("atccta");
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        boolean isPalindrome = true;
        int endPoint = s.length() - 1;
        for (int startPoint = 0; startPoint <= s.length() / 2 - 1; startPoint++) {
            if (s.charAt(startPoint) != s.charAt(endPoint)) {
                isPalindrome = false;
                break;
            }
            endPoint--;
        }
        return isPalindrome;
    }
}
