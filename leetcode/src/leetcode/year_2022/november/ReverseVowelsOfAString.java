package leetcode.year_2022.november;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("hello"));
        System.out.println(new ReverseVowelsOfAString().reverseVowels("leetcode"));
        System.out.println(new ReverseVowelsOfAString().reverseVowels("aA"));
    }

    public String reverseVowels(String s) {
        char[] sChar = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        boolean leftFind = false;
        boolean rightFind = false;
        while (left < right) {
            if (!leftFind) {
                if (check(sChar, left)) {
                    leftFind = true;
                } else {
                    left++;
                }
            }
            if (!rightFind) {
                if (check(sChar, right)) {
                    rightFind = true;
                } else {
                    right--;
                }
            }
            if (leftFind && rightFind) {
                swap(sChar, left, right);
                leftFind = false;
                rightFind = false;
                left++;
                right--;
            }
        }
        return new String(sChar);
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    private boolean check(char[] s, int idx) {
        return s[idx] == 'a' || s[idx] == 'e' || s[idx] == 'i' || s[idx] == 'o' || s[idx] == 'u' || s[idx] == 'A' || s[idx] == 'E' || s[idx] == 'I' || s[idx] == 'O' || s[idx] == 'U';
    }
}
