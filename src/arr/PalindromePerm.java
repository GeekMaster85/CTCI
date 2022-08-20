package arr;

import java.util.*;

public class PalindromePerm {
    static boolean isPalindromePerm(String s) {
        s = s.toUpperCase().replaceAll(" ", "");
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar))
                map.put(aChar, map.get(aChar) + 1);
            else
                map.put(aChar, 1);
        }
        int count = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                count++;
                if (count == 2)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac", "Tact Coa",
                "asda"};
        for (String string : strings) {
            System.out.println(isPalindromePerm(string));
        }
    }
}
