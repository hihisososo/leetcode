package leetcode;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(new CountPrimes().countPrimes(n));
    }

    public int countPrimes(int n) {
        int end = (int) Math.sqrt(n);
        boolean[] numbers = new boolean[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = true;
        }
        for (int i = 2; i <= end; i++) {
            int multiple = 2;
            while (i * multiple <= n) {
                numbers[i * multiple] = false;
                multiple++;
            }
        }
        int result = 0;
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i]) {
                result++;
            }
        }
        return result;
    }
}
