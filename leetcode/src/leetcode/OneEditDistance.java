package leetcode;

public class OneEditDistance {
    public static void main(String[] args) {
        String s = "";
        String t = "A";
        System.out.println(new OneEditDistance().isOneEditDistance(s, t));
    }

    public boolean isOneEditDistance(String s, String t) {
        boolean isEdit = false;
        int sIdx = 0;
        int tIdx = 0;
        while (sIdx < s.length() && tIdx < t.length()) {
            char sc = s.charAt(sIdx);
            char tc = t.charAt(tIdx);

            if (sc == tc) {
                sIdx++;
                tIdx++;
            } else {
                if (isEdit) {
                    return false;
                }
                isEdit = true;
                if (s.length() > t.length()) {
                    sIdx++; //delete
                } else if (s.length() < t.length()) {
                    tIdx++; //insert
                } else {
                    sIdx++; //replace
                    tIdx++;
                }
            }
        }

        if(isEdit){
            return sIdx == s.length() && tIdx == t.length();
        }else{
            return Math.abs(s.length() - t.length()) == 1;
        }
    }
}
