package leetcode.year_2022.september;

import java.util.LinkedList;
import java.util.Queue;

public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(new PushDominoes().pushDominoes("RR.L"));
        System.out.println(new PushDominoes().pushDominoes(".L.R...LR..L.."));
        System.out.println(new PushDominoes().pushDominoes("R.R.L"));
    }

    public String pushDominoes(String dominoes) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        boolean rightAppeared = false;
        for (int i = 0; i < dominoes.length(); i++) {
            Character direction = dominoes.charAt(i);
            queue.add(direction);
            if (direction == 'L') {
                if (rightAppeared) {
                    int size = queue.size();
                    boolean midExist = size % 2 == 1;
                    int rightCnt = size / 2;
                    while (!queue.isEmpty()) {
                        queue.poll();
                        if (rightCnt > 0) {
                            result.append('R');
                            rightCnt--;
                        } else {
                            if (midExist) {
                                result.append('.');
                                midExist = false;
                            } else {
                                result.append('L');
                            }
                        }
                    }
                } else {
                    while (!queue.isEmpty()) {
                        queue.poll();
                        result.append('L');
                    }
                }
                rightAppeared = false;
            } else if (direction == 'R') {
                rightAppeared = true;
                if (queue.size() > 1 && queue.peek().equals('R')) {
                    while (queue.size() > 1){
                        queue.poll();
                        result.append('R');
                    }
                }else if(queue.size() > 1){
                    while (queue.size() > 1){
                        queue.poll();
                        result.append('R');
                    }
                }
            }
        }
        Character remain = '.';
        if (queue.contains('R')) {
            remain = 'R';
        }
        for (int i = 0; i < queue.size(); i++) {
            result.append(remain);
        }
        return result.toString();
    }
}
