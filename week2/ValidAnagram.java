package week2;

import java.util.ArrayList;

/*
 * https://leetcode.com/problems/valid-anagram/
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * */
public class ValidAnagram {

    public static long MOD = 101103107109113L;
    public static int BASE = 997;

    private static long getHash(String s) {
        long hash = 1;

        for (char c : s.toCharArray()) {
            hash *= BASE + (c - 'a');
            if (hash >= MOD) {
                hash = hash % MOD;
            }
        }
        return hash;
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        return getHash(s) == getHash(t);

        // There is another way to do that
       /* int[] charFrequency = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            charFrequency[index]++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            charFrequency[index]--;
        }
        for (int value : charFrequency) {

            if(value > 0) return false;
        }
        return true;*/

    }

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "ganaram"));
    }
}
