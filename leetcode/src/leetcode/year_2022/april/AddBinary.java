package leetcode.year_2022.april;

import java.util.Arrays;
import java.util.Iterator;

public class AddBinary {

  public static void main(String[] args) {

  }

  public String addBinary(String a, String b) {
    Iterator<Character> aReverseIter = Arrays.asList(
        new StringBuilder(a).reverse().toString().toCharArray()).iterator();
    Iterator<Character> bReverseIter = Arrays.asList(
        new StringBuilder(b).reverse().toString().toCharArray()).iterator();
    StringBuilder result = new StringBuilder();

    for (aReverseIter.hasNext() && bReverseIter.hasNext()) {
      boolean carry = false;
      int aChar = Integer.parseInt(aReverseIter.next());
      int bChar = Integer.parseInt(bReverseIter.next());
      int sum = aChar + bChar;

      if(aChar == '1' && bChar == '1'){
        carry =true;
        if(carry){
          result.append("1");
        }else{
          result.append("0");
        }
      }
    }
  }
}
