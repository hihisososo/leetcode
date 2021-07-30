package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(22
                , 7));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        boolean isPositive = (numerator >= 0 && denominator >= 0) || (numerator < 0 && denominator < 0);
        long nume = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        if (nume % deno == 0) {
            return (isPositive ? "" : "-") + String.valueOf(nume / deno);
        }

        String pointPrefix = "";
        long remnant = 0;
        if (nume >= denominator) {
            long quotent = nume / deno;
            remnant = nume - quotent * deno;
            remnant *= 10;
            pointPrefix = String.valueOf(quotent) + ".";
        } else {
            nume *= 10;
            remnant = nume;
            pointPrefix = "0.";
        }

        StringBuffer pointSuffix = new StringBuffer();
        HashMap<Long,Integer> repeatCheckMap = new HashMap<>();
        while (remnant != 0) {
            if (repeatCheckMap.containsKey(remnant)) {
                int idx = repeatCheckMap.get(remnant);
                pointSuffix.insert(idx, '(').insert(pointSuffix.length(), ')');
                break;
            }
            repeatCheckMap.put(remnant, pointSuffix.length());
            long quotent = remnant / deno;
            pointSuffix.append(quotent);
            remnant -= quotent * deno;
            remnant *= 10;
        }

        if (isPositive) {
            return pointPrefix + pointSuffix.toString();
        } else {
            return "-" + pointPrefix + pointSuffix.toString();
        }
    }
}
