package leetcode.year_2022.april;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        String[] splitted = s.replaceAll(" +", " ").split(" ");
        return splitted[splitted.length - 1].length();
    }

}
