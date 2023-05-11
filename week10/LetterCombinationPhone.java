package week10;

import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationPhone {


    public static void main(String[] args) {

        String input = "";
        LetterCombinationPhoneImplementation implementation = new LetterCombinationPhoneImplementation();
        System.out.println();
        System.out.println(implementation.letterCombinations(input));

        /* correct answer for "23" is :  ["ad","ae","af","bd","be","bf","cd","ce","cf"] */
    }

    /*
    1       2       3
    -       abc     def
    4       5       6
   ghi     jkl     mno
    7       8       9
   pqrs    tuv     wxyz
    * */
}

class LetterCombinationPhoneImplementation {


    private ArrayList<String> results = new ArrayList<>();
    private HashMap<String, String> buttonCharacter;
    private String currString = "";


    private HashMap<String, String> generateButtonCharater() {
        HashMap<String, String> buttonCharacterMap = new HashMap<>();

        buttonCharacterMap.put("2", "abc");
        buttonCharacterMap.put("3", "def");
        buttonCharacterMap.put("4", "ghi");
        buttonCharacterMap.put("5", "jkl");
        buttonCharacterMap.put("6", "mno");
        buttonCharacterMap.put("7", "pqrs");
        buttonCharacterMap.put("8", "tuv");
        buttonCharacterMap.put("9", "wxyz");

        return buttonCharacterMap;
    }


    private void generate(int position, String digits) {

        if (position == digits.length()) {
            if(currString != null){
                results.add(currString);
            }
            return;
        }

        String character = String.valueOf(digits.charAt(position));

        for (char c : buttonCharacter.get(character).toCharArray()) {

            currString += String.valueOf(c);
            generate(position + 1, digits);
            currString = new String(Arrays.copyOf(currString.toCharArray(), currString.toCharArray().length - 1));
            /* Removed the last char, so for 23 -> [ad -> a] ( `d` is removed, so `e` can be added in next recursion,
             and next recursion can be [a->ae],

             otherwise [ade -> adef -> ....... */

        }
    }


    public List<String> letterCombinations(String digits) {

        buttonCharacter = generateButtonCharater();

        generate(0, digits);

        return results;
    }
}
