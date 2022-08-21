package arr;

import java.util.*;


public class Perm {
    static String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    static boolean isPerm(String s1, String s2) {
        if (s2.length() != s1.length())
            return false;
        return sort(s1).equals(sort(s2));
    }
    static boolean isPerm1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] letters = new int[128];
        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            letters[aChar]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            letters[c]--;
            if (letters[c] < 0)
                return false;
        }
        return true;

    }
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPerm1(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
