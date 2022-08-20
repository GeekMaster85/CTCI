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
            if (isOneAway(a, b) == expected) {
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
