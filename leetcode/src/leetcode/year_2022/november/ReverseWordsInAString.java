package leetcode.year_2022.november;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        String[] splitted = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = splitted.length - 1; i >= 0; i--) {
            if (splitted[i].trim().isEmpty()) {
                continue;
            }
            sb.append(splitted[i] + " ");
        }
        return sb.toString().trim();
    }
}
