package leetcode.year_2022.september;

public class Utf8Validation {
    public static void main(String[] args) {
//        System.out.println(new Utf8Validation().validUtf8(new int[]{197, 130, 1}));
//        System.out.println(new Utf8Validation().validUtf8(new int[]{235, 140, 4}));
//        System.out.println(new Utf8Validation().validUtf8(new int[]{145}));
//        System.out.println(new Utf8Validation().validUtf8(new int[]{230, 136, 145}));
//        System.out.println(new Utf8Validation().validUtf8(new int[]{250, 145, 145, 145, 145}));
        System.out.println(new Utf8Validation().validUtf8(new int[]{0, 171, 183, 174}));
    }

    public boolean validUtf8(int[] data) {
        int byteIdx = 0;
        while (byteIdx < data.length) {
            String firstByte = padLeftZeros(Integer.toBinaryString(data[byteIdx++]));
            int byteLen = getByteLen(firstByte);
            if (byteLen > 4 || byteLen == 1) {
                return false;
            }
            if (byteLen == 0) {
                continue;
            }
            int end = byteIdx + byteLen - 1;
            if (end > data.length || byteIdx >= data.length) {
                return false;
            }
            for (; byteIdx < end; byteIdx++) {
                String byteStr = padLeftZeros(Integer.toBinaryString(data[byteIdx]));
                if (!byteStr.startsWith("10")) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getByteLen(String firstByte) {
        int cnt = 0;
        for (char c : firstByte.toCharArray()) {
            if (c == '1') {
                cnt++;
            } else {
                return cnt;
            }
        }
        return cnt;
    }

    public String padLeftZeros(String inputString) {
        if (inputString.length() >= 8) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 8 - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
