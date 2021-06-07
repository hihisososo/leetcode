package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

	long allSize = 0;
	long maxHeapSize = 0;
	long minHeapSize = 0;
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	}

	public void addNum(int num) {

		if(allSize == 0){
			allSize++;
			maxHeapSize++;
			maxHeap.offer(num);
			return;
		}

		allSize++;
		if(maxHeapSize > minHeapSize){
			int max = maxHeap.peek();
			minHeapSize++;
			if(max < num){
				minHeap.offer(num);
			}else{
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(num);
			}
		}else{
			int max = minHeap.peek();
			maxHeapSize++;
			if(max < num){
				maxHeap.offer(minHeap.poll());
				minHeap.offer(num);
			}else{
				maxHeap.offer(num);
			}
		}
	}

	public double findMedian() {
		if(allSize % 2 == 1){
			return maxHeap.peek();
		}else{
			return (double)(maxHeap.peek() + minHeap.peek()) / 2;
		}
	}

	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		obj.addNum(2);
		System.out.println(obj.findMedian());
		obj.addNum(3);
		System.out.println(obj.findMedian());
	}
}