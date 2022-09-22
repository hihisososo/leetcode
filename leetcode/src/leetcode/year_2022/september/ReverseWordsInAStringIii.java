package leetcode.year_2022.september;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIii().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        char[] result = new char[s.length()];
        String[] splitted = s.split(" ");
        int index = 0;
        for (String split : splitted) {
            for (int i = split.length() - 1; i >= 0; i--) {
                result[index++] = split.charAt(i);
            }
            if (index < result.length) {
                result[index++] = ' ';
            }
        }
        return new String(result);
    }
}
