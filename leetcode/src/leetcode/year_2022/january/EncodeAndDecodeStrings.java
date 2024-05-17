package leetcode.year_2022.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        EncodeAndDecodeStrings ed = new EncodeAndDecodeStrings();
        System.out.println(ed.decode(ed.encode(Arrays.asList(new String[]{",", ",", ","}))));
    }

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.size(); i++) {
            if (i == 0) {
                sb.append(strs.get(i).replaceAll(",", "\\\\,"));
            } else {
                sb.append("," + strs.get(i).replaceAll(",", "\\\\,"));
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        char[] sChars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '\\' && i + 1 < sChars.length && sChars[i + 1] == ',') {
                sb.append(",");
                i++;
                continue;
            }
            if (sChars[i] == ',') {
                result.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append(sChars[i]);
            }

        }
        result.add(sb.toString());
        return result;
    }
}
