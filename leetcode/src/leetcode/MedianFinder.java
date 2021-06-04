package leetcode;

class MedianFinder {

	long size = 0;
	int[] number = new int[200001];

	public MedianFinder() {
	}

	public void addNum(int num) {
		number[num]++;
		size++;
	}

	public double findMedian() {
		if (size % 2 == 0) {
			return (double) sum / size;
		} else {
			return midVal;
		}
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