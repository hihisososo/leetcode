package leetcode;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(new HappyNumber().isHappy(n));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> cycleSet = new HashSet<>();
        while(n != 1){
            if(cycleSet.contains(n)){
                return false;
            }
            cycleSet.add(n);
            String nStr = String.valueOf(n);
            int sum = 0;
            for (int i = 0; i < nStr.length(); i++) {
                sum += Math.pow(Integer.parseInt(nStr.substring(i,i+1)), 2);
            }
            n = sum;
        }
        return true;
    }
}
