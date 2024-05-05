package leetcode.year_2024.may;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int front = 0;
        for (int back = people.length - 1; back >= 0 && front <= back; back--) {
            if (people[front] + people[back] <= limit) {
                front++;
            }
            cnt++;
        }
        return cnt;
    }
}
