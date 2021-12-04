package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(makeStr(i));
        }
        return result;
    }

    private String makeStr(int i) {
        if(i % 3 == 0 && i % 5 == 0){
            return "FizzBuzz";
        }else if(i % 3 == 0){
            return "Fizz";
        }else if(i % 5  == 0){
            return "Buzz";
        }else{
            return String.valueOf(i);
        }
    }
}
