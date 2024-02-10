package com.educative.algo77solutions.module7.subsets;

import java.util.ArrayList;

public class Permutations {
    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> result = new ArrayList<String>();
        permuteWordRecursive(word, result, 0);
        return result;
    }

    private static void permuteWordRecursive(String word, ArrayList<String> strings, int index) {
        if (index == word.length() - 1) {
            strings.add(word);
            return;
        }

        for (int i = index; i < word.length(); i++) {
            String swappedWord = swap(word, index, i);
            permuteWordRecursive(swappedWord, strings, index + 1);
        }
    }

    private static String swap(String word, int index, int i) {
        char[] chars = word.toCharArray();
        char temp = chars[i];
        chars[i] = chars[index];
        chars[index] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(
                permuteWord("goc")
        );
    }
}
