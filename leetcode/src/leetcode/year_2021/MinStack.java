package leetcode.year_2021;

class MinStack {
    private int[] array;
    private int minVal;
    private int idx;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        array = new int[30000];
        minVal = Integer.MAX_VALUE;
        idx = -1;
    }

    public void push(int val) {
        if (idx == -1) {
            array[++idx] = val;
            minVal = val;
        } else {
            array[++idx] = val;
            if (val < minVal) {
                minVal = val;
            }
        }
    }

    public void pop() {
        if (minVal == array[idx] && idx != 0) {
            minVal = array[idx - 1];
            for (int i = 0; i < idx - 1; i++) {
                if (array[i] < minVal) {
                    minVal = array[i];
                }
            }
        }
        --idx;
    }

    public int top() {
        return array[idx];
    }

    public int getMin() {
        return minVal;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}