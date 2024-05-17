package leetcode.year_2022.june;

import java.util.Collections;
import java.util.PriorityQueue;

public class PutBoxesIntoTheWarehouseI {
    public static void main(String[] args) {
//        int[] boxes = new int[]{4, 3, 4, 1};
//        int[] warehouse = new int[]{5, 3, 3, 4, 1};
        int[] boxes = new int[]{1, 2, 3};
        int[] warehouse = new int[]{1, 2, 3, 4};
        System.out.println(new PutBoxesIntoTheWarehouseI().maxBoxesInWarehouse(boxes, warehouse));
    }

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        PriorityQueue<Integer> boxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int box : boxes) {
            boxQueue.add(box);
        }

        int boxAdded = 0;
        for (int height : warehouse) {
            removePeek(boxQueue, height);

            if (boxQueue.isEmpty()) {
                break;
            } else {
                boxQueue.poll();
                boxAdded++;
            }
        }
        return boxAdded;
    }

    private void removePeek(PriorityQueue<Integer> boxQueue, int height) {
        while (boxQueue.peek() != null && boxQueue.peek() > height) {
            boxQueue.poll();
        }
    }
}
