package week10;

public class Palindrome {

    public static boolean isPalindrome(char[] s, int left, int right) {

        if (left >= right) return true;
        if(s[left] == s[right]){
            return isPalindrome(s, left + 1, right - 1);
        }
        return false;
    }

    public static void main(String[] args) {

        String input = "madam";
        boolean answer = isPalindrome(input.toCharArray(), 0, input.length() - 1);

        System.out.println();
        System.out.println(answer);
    }
}
