package week12;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

    /*
    Time Complexity 2n, L = n and R = n, so L+R = 2n
    * */
    public static int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int maxLen = 0; int duplicate = 0;
        int kAllowed = 1;

        for (int left = 0, right = 0; right < s.length(); right++) {
            freq[s.charAt(right)]++;
            if(freq[s.charAt(right)] > kAllowed){
                duplicate++;
            }
            while (duplicate > 0){
                freq[s.charAt(right)]--;
                if(freq[s.charAt(right)] == kAllowed){
                    duplicate--;
                }
                left++;
            }
            maxLen = Integer.max(maxLen, right-left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
