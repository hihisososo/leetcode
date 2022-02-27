package leetcode.year_2022.february;

import java.util.ArrayDeque;

public class DesignHitCounter {
    public static void main(String[] args) {
        DesignHitCounter hitCounter = new DesignHitCounter();
        hitCounter.hit(1);       // hit at timestamp 1.
        hitCounter.hit(2);       // hit at timestamp 2.
        hitCounter.hit(3);       // hit at timestamp 3.
        System.out.println(hitCounter.getHits(4));   // get hits at timestamp 4, return 3.
        hitCounter.hit(300);     // hit at timestamp 300.
        System.out.println(hitCounter.getHits(300)); // get hits at timestamp 300, return 4.
        System.out.println(hitCounter.getHits(301)); // get hits at timestamp 301, return 3.
    }


    private ArrayDeque<Integer> hits;

    public DesignHitCounter() {
        this.hits = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        hits.addLast(timestamp);
        while(!hits.isEmpty() && timestamp - hits.getFirst() >= 300){
            hits.pollFirst();
        }
    }

    public int getHits(int timestamp) {
        while(!hits.isEmpty() && timestamp - hits.getFirst() >= 300){
            hits.pollFirst();
        }
        return hits.size();
    }
}
