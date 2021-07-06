package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >=0 ; i--) {
            int digit = digits[i];
            if(digit == 9 && carry == 1){
                result.addFirst(0);
                carry = 1;
            }else{
                result.addFirst(digit + carry);
                carry = 0;
            }
        }
        if(carry == 1){
            result.addFirst(carry);
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
