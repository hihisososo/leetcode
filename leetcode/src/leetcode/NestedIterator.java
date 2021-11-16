package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    public static void main(String[] args) {

        List<NestedInteger> list = new ArrayList<NestedInteger>();
        List<NestedInteger> list1 = new ArrayList<NestedInteger>();
        List<NestedInteger> list2 = new ArrayList<NestedInteger>();
        list1.add(new MyNestedInteger(1));
        list1.add(new MyNestedInteger(1));
        list2.add(new MyNestedInteger(1));
        list2.add(new MyNestedInteger(1));
        list.add(new MyNestedInteger(list1));
        list.add(new MyNestedInteger(2));
        list.add(new MyNestedInteger(list2));
        NestedIterator iter = new NestedIterator(list);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

    private List<NestedInteger> nestedList;
    private List<Integer> list;
    private int curridx = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        makeList();
    }

    private void makeList() {
        list = new ArrayList<>();
        traverse(nestedList);
    }

    private void traverse(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                list.add(nestedList.get(i).getInteger());
            } else {
                traverse(nestedList.get(i).getList());
            }
        }
    }

    @Override
    public Integer next() {
        Integer val = list.get(curridx);
        curridx++;
        return val;
    }

    @Override
    public boolean hasNext() {
        return curridx < list.size();

    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    public static class MyNestedInteger implements NestedInteger {
        Integer value;
        List<NestedInteger> nestedList;

        public MyNestedInteger(Integer value) {
            this.value = value;
        }

        public MyNestedInteger(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        // @return true if this NestedInteger holds a single integer, rather
        // than a nested list.
        public boolean isInteger() {
            return value != null;
        }

        // @return the single integer that this NestedInteger holds, if it holds
        // a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }

        // @return the nested list that this NestedInteger holds, if it holds a
        // nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return nestedList;
        }

    }


}
