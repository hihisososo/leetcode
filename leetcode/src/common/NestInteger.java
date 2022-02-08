package common;

import java.util.ArrayList;
import java.util.List;

public class NestInteger implements NestedInteger {
    Integer i;
    List<NestedInteger> iList;

    public NestInteger() {
        iList = new ArrayList<NestedInteger>();
    }

    public NestInteger(int value) {
        this.i = value;
    }

    @Override
    public boolean isInteger() {
        return i != null;
    }

    @Override
    public Integer getInteger() {
        return i;
    }

    @Override
    public void setInteger(int value) {
        this.i = value;
    }

    @Override
    public void add(NestedInteger ni) {
        iList.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return iList;
    }
}
