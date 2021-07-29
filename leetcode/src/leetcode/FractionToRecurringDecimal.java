package leetcode;

import java.util.HashSet;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(4, 333));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long nume = numerator;
        boolean isRepeat = false;
        int multipleCnt = 0;
        HashSet<Long> repeatSet = new HashSet<>();
        StringBuffer resultSb = new StringBuffer();

        while(nume < denominator){
            multipleCnt++;
            nume *= 10;
        }

        while(nume == 0 || !isRepeat){
            if(repeatSet.get(nume)){

            }
            long quotent = nume / denominator;
            resultSb.append(quotent);
            nume -= quotent * denominator;
            repeatSet.add(nume);
            nume *=10;
        }
    }

}
