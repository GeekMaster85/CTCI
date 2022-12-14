package arr;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class OneAway {
    static boolean isOneAway(String s1, String s2) {
        if (abs(s1.length() - s2.length()) >= 2)
            return false;
        else if (abs(s1.length() - s2.length()) == 0) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int cnt = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (chars1[i] != chars2[i])
                    cnt++;
                if (cnt == 2)
                    return false;
            }
            return true;
        } else {
            List<String> pick = pick(s1, s2);
            s1 = pick.get(0);
            s2 = pick.get(1);
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int i = 0, j = 0;
            while (j < s2.length()) {
                if (chars1[i] == chars2[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                    if (chars1[i] == chars2[j]) {
                        i++;
                        j++;
                    } else
                        return false;
                }
            }
            return true;
        }
    }

    static List<String> pick(String s1, String s2) {
        List<String> list = new ArrayList<>();
        if (s1.length() > s2.length()) {
            list.add(s1);
            list.add(s2);
        } else {
            list.add(s2);
            list.add(s1);
        }
        return list;
    }

    static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference)
                    return false;
                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    static boolean oneEditInsert(String s1, String s2) {
        int i1 = 0;
        int i2 = 0;
        while (i2 < s2.length() && i1 < s1.length()) {
            if (s1.charAt(i1) != s2.charAt(i2)) {
                if (s1.charAt(i1) != s2.charAt(++i2))
                    return false;
            } else {
                i1++;
                i2++;
            }
        }
        return true;
    }

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length())
            return oneEditReplace(first, second);
        else if (first.length() + 1 == second.length())
            return oneEditInsert(first, second);
        else if (first.length() - 1 == second.length())
            return oneEditInsert(second, first);
        else
            return false;
    }
    public static boolean oneEditAway1(String first, String second) {
        if (abs(first.length() - second.length()) > 1)
            return false;
        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;
        int i1 = 0;
        int i2 = 0;
        boolean foundDifference = false;
        while (i1 < shorter.length() && i2 < longer.length()) {
            if (shorter.charAt(i1) != longer.charAt(i2)){
                if (foundDifference) return false;
                foundDifference = true;
                if (shorter.length() == longer.length())
                    i1++;
            } else {
                i1++;
            }
            i2++;
        }
        return true;
    }
    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        int s = 0, f = 0;

        for (String[] test : tests) {
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");
            if (oneEditAway(a, b) == expected) {
                System.out.println("s");
                s++;
            } else {
                System.out.println("f");
                f++;
            }

        }
        System.out.println(s);
        System.out.println(f);
    }
}
