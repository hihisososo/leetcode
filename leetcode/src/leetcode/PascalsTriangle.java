package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                rowList.add(1);
            }
            result.add(rowList);
        }

        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = 1; j < result.get(i).size(); j++) {
                result.get(i + 1).set(j, result.get(i).get(j) + result.get(i).get(j - 1));
            }
        }

        return result;
    }
}
