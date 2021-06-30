package leetcode;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int divedend = -2147483648;
        int divisort = 1;
        System.out.println(new DivideTwoIntegers().divide(divedend, divisort));
    }

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            return -dividend;
        }

        boolean isPlus = false;
        if((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor <0)){
            isPlus = true;
        }

        if(dividend > 0){
            dividend = -1 * dividend;
        }
        divisor = Math.abs(divisor);

        int cnt = 0;
        while(dividend <= -divisor){
            cnt++;
            dividend += divisor;
        }

        if(isPlus){
            return cnt;
        }else{
            return -1 * cnt;
        }
    }


}
