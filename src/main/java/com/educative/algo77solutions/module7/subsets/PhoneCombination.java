package com.educative.algo77solutions.module7.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneCombination {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.isEmpty())
            return result;
        // initialize dictionary;
        Map<Integer, List<Character>> dictionary = new HashMap<Integer, List<Character>>();
        dictionary.put(1, List.of(Character.MIN_VALUE));
        char a = 'a' - 1;
        int digit = 2;
        while (digit < 10) {
            List<Character> chars = new ArrayList<Character>();
            for (int i = 0; i < 3; i++) {
                a++;
                chars.add(a);
            }
            if (digit == 7 || digit == 9) {
                a++;
                chars.add(a);
            }
            dictionary.put(digit, chars);
            digit++;
        }

        letterCombinationsRec(digits, dictionary, 0, result, "");
        return result;
    }

    public void letterCombinationsRec(String digits,Map<Integer, List<Character>> dictionary, int index,
                                      List<String> result,
                                      String currentCombination) {
        if (index == digits.length()) {
            result.add(currentCombination);
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(index));
        List<Character> chars = dictionary.get(digit);
        for(char c : chars) {
         letterCombinationsRec(digits, dictionary, index + 1, result, currentCombination + c);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new PhoneCombination().letterCombinations("12")
        );
    }
}
