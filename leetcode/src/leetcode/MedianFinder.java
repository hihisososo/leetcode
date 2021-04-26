package leetcode;

class MedianFinder {

	long sum = 0;
	int size = 0;
	int leftInserted = 0;
	int rightInserted = 0;
	int midLeftVal = 0;
	int midRightVal = 0;
	int midVal = Integer.MIN_VALUE;

	public MedianFinder() {

	}

	public void addNum(int num) {
		if (size == 0) {
			midVal = num;
		}

		sum += num;
		size++;
		if (midVal <= num) {
			rightInserted++;
			midRightVal = num;
		} else {
			leftInserted++;
			midLeftVal = num;
		}
		if (size % 2 != 0) {
			if (leftInserted == 2) {
				midVal = midLeftVal;
			} else if (rightInserted == 2) {
				midVal = midRightVal;
			}else{
				midLeftVal = 
			}
			leftInserted = 0;
			rightInserted = 0;
		}
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