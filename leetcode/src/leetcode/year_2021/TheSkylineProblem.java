package leetcode.year_2021;

import java.util.*;

public class TheSkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new TheSkylineProblem().getSkyline(buildings));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Building> startQueue = new PriorityQueue<>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Building> endQueue = new PriorityQueue<>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                return o1.end - o2.end;
            }
        });
        PriorityQueue<Building> heightQueue = new PriorityQueue<>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                return o2.height - o1.height;
            }
        });

        HashSet<Integer> changePointSet = new HashSet<>();
        for (int i = 0; i < buildings.length; i++) {
            Building building = new Building(buildings[i][0], buildings[i][1], buildings[i][2]);
            startQueue.add(building);
            endQueue.add(building);
            changePointSet.add(buildings[i][0]);
            changePointSet.add(buildings[i][1]);
        }
        ArrayList<Integer> changePoints = new ArrayList<>(changePointSet);
        Collections.sort(changePoints);

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int lastVal = -1;
        for (int i = 0; i < changePoints.size(); i++) {
            int changeIdx = changePoints.get(i);

            while (!startQueue.isEmpty()) {
                Building peek = startQueue.peek();
                if (peek.start <= changeIdx) {
                    heightQueue.add(startQueue.poll());
                } else {
                    break;
                }
            }

            while (!endQueue.isEmpty()) {
                Building peek = endQueue.peek();
                if (peek.end <= changeIdx) {
                    heightQueue.remove(endQueue.poll());
                } else {
                    break;
                }
            }

            int peekHeight = heightQueue.isEmpty() ? 0 : heightQueue.peek().height;
            if (checkLastVal(lastVal, peekHeight)) {
                List<Integer> point = new ArrayList<>();
                point.add(changeIdx);
                point.add(peekHeight);
                lastVal = peekHeight;
                results.add(point);
            }

        }
        return results;
    }

    private boolean checkLastVal(int lastVal, int peekHeight) {
        return lastVal != peekHeight;
    }

    class Building {
        int start;
        int end;
        int height;

        public Building(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }
}
