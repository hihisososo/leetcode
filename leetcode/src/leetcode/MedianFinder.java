package leetcode;

import java.util.PriorityQueue;

class MedianFinder {

	long allSize = 0;
	long maxHeapSize = 0;
	long minHeapSize = 0;
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		allSize++;
		if(allSize == 0){
			maxHeapSize++;
			maxHeap.offer(num);
			return;
		}

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
				maxHeap.offer(num);
			}else{
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(num);
			}
		}
		int middle = maxHeap.peek();
		if(num > middle){
			minHeap.offer(num);
		}
		size++;
	}

	public double findMedian() {
		if (size % 2 == 0) {
			return (double) sum / size;
		} else {
			return midVal;
		}
		return 0;
	}

	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(-1);
		obj.addNum(-2);
		obj.addNum(-3);
		obj.addNum(-4);
		obj.addNum(-5);
		System.out.println(obj.findMedian());
	}
}