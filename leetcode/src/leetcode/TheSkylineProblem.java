package leetcode;

import java.util.*;

public class TheSkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new TheSkylineProblem().getSkyline(buildings));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        /*PriorityQueue<Building> queue = new PriorityQueue<>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                if (o1.start == o2.start) {
                    return o2.height - o1.height;
                }
                return o1.end - o2.end;
            }
        });*/

        PriorityQueue<Integer> endQueue = new PriorityQueue<>();
        PriorityQueue<Integer> heightQueue = new PriorityQueue<>();
        HashSet<Integer> changePointSet = new HashSet<>();
        for (int i = 0; i < buildings.length; i++) {
            queue.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
            changePointSet.add(buildings[i][0]);
            changePointSet.add(buildings[i][1]);
        }
        ArrayList<Integer> changePoints = new ArrayList<>(changePointSet);
        Collections.sort(changePoints);

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int max = 0;
        for (int i = 0; i < changePoints.size(); i++) {
            int changeIdx = changePoints.get(i);
            while (!queue.isEmpty()) {
                if (queue.peek().end <= changeIdx) {
                    queue.poll();
                } else {
                    List<Integer> point = new ArrayList<>();
                    point.add(changeIdx);
                    point.add(queue.peek().height);
                    results.add(point);
                    break;
                }
            }
        }
        return results;
    }

    /*class Building {
        int start;
        int end;
        int height;

        public Building(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }*/


}
