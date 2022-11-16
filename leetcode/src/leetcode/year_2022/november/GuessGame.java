package leetcode.year_2022.november;

import java.util.Random;

public class GuessGame {
    private int pick;

    public GuessGame(int n) {
        this.pick = new Random().nextInt(n + 1);
    }

    public int guess(int num) {
        System.out.println("pick: " + pick + " num:" + num);
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }


}
