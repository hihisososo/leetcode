package leetcode.year_2022.october;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(30));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String prev = countAndSay(n - 1);
        char prevChar = prev.charAt(0);
        int cnt = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prevChar != prev.charAt(i)) {
                sb.append(String.valueOf(cnt) + prevChar);
                cnt = 1;
                prevChar = prev.charAt(i);
            } else {
                cnt++;
            }
        }
        sb.append(String.valueOf(cnt) + prevChar);
        return sb.toString();
    }
}
