package arr;

public class Compression {
    static String compress(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                stringBuilder.append(s.charAt(i));
                stringBuilder.append(cnt);
                cnt = 1;
            }
        }
        stringBuilder.append(s.charAt(s.length() - 1));
        stringBuilder.append(cnt);
        return stringBuilder.length() < s.length() ? stringBuilder.toString() : s;
    }

    public static void main(String[] args) {
        System.out.println(compress("abcaaaaaa"));
    }
}
