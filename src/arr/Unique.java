package arr;

import java.util.HashSet;
import java.util.Set;

public class Unique {

    static boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            set.add(aChar);
        }
        return set.size() == s.length();
    }

    static boolean isUniqueChars(String s) {
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (char_set[c])
                return false;
            char_set[c] = true;
        }
        return true;
    }

    static boolean isUniqueChars1(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            int b = 1 << val;
            int a = checker & (1 << val);
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= 1 << val;
        }
        return true;
    }

    static boolean linearCheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt((i + 1) % s.length()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "aPple", "kitk", "padle"};
        for (String word : words) {
            System.out.println(linearCheck(word));
        }
    }
}
