package ru.taxcom.mobile.android.basedynamiclist.model;


public abstract class DataListItem implements BaseListItem {

    protected String mId;
    protected int mState = 0;

    public void setNextState(int statesCount) {
        mState++;
        if (mState >= statesCount) {
            mState = 0;
        }
    }

    public int getDataState() {
        return mState;
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    protected boolean safeFieldEquals(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        } else if (o1 == null || o2 == null) {
            return false;
        } else {
            return o1.equals(o2);
        }
    }

    public String getId() {
        return mId;
    }

    @Override
    public Type getType() {
        return Type.DATA;
    }
}
