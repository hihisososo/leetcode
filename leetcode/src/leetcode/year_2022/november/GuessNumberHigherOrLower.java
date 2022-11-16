package leetcode.year_2022.november;

public class GuessNumberHigherOrLower extends GuessGame {
    public GuessNumberHigherOrLower(int n) {
        super(n);
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherOrLower(1000).guessNumber(1000));

    }


    public int guessNumber(int n) {
        int prev = 0;
        int num = n;
        int result = 0;
        while ((result = guess(num)) != 0) {
            int amount = Math.abs(prev - num) / 2 == 0 ? 1 : Math.abs(prev - num) / 2;
            prev = num;
            if (result == -1) {
                num -= amount;
            } else if (result == 1) {
                num += amount;
            }
        }
        return num;
    }
}
