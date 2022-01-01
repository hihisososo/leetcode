package leetcode.year_2021;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new CountAndSay().countAndSay(n));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String sayRst = countAndSay(n - 1);
        String result = "";
        for (int i = 0; i < sayRst.length(); i++) {
            char c = sayRst.charAt(i);
            int cnt = 1;
            for (int j = i + 1; j < sayRst.length(); j++) {
                if (c == sayRst.charAt(j)) {
                    cnt++;
                    i = j;
                } else {
                    break;
                }
            }
            result += cnt;
            result += c;
        }

        return result;
    }
}
