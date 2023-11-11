package leetcode.year_2023.november;

public class CountNumberOfHomogenousSubstrings {

  public static void main(String[] args) {
    System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous("abbcccaa"));
    System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous("xy"));
    System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous("zzzzz"));
  }

  public int countHomogenous(String s) {
    long sum = 0;
    long len = 1;
    long cal = 0;
    int modulo = 1000000000 + 7;
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        len++;
      } else {
        cal = (len * (len + 1)) / 2 % modulo;
        sum += cal;
        sum %= modulo;
        len = 1;
      }
    }
    cal = (len * (len + 1)) / 2 % modulo;
    sum += cal;
    sum %= modulo;

    return (int)sum;
  }


}
