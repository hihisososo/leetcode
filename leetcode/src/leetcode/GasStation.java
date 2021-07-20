package leetcode;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (canCompleteCircuit(i, gas, cost)) {
                return i;
            }
        }
        return -1;

    }

    private boolean canCompleteCircuit(int startIdx, int[] gas, int[] cost) {
        int idx = startIdx;
        int fuel = gas[startIdx];
        boolean isStart = true;

        for (; ; ) {
            fuel -= cost[idx];
            if (fuel < 0) {
                return false;
            }
            if (idx == startIdx) {
                if (isStart) {
                    isStart = false;
                } else {
                    return true;
                }
            }
            idx = getNextIdx(idx, gas.length);
            fuel += gas[idx];
        }
    }

    private int getNextIdx(int startIdx, int length) {
        if (startIdx < length - 1) {
            return startIdx + 1;
        }
        return startIdx - length + 1;
    }
}
