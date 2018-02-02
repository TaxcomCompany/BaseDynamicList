package ru.taxcom.mobile.android.basedynamiclist.model;



import ru.taxcom.mobile.android.basedynamiclist.utils.EqualUtil;

public class DataListItem<T extends ListData> {

    public static int DATA = 0;
    public static int HEADER = 1;
    public static int PROGRESS = 2;
    public static int ERROR = 3;

    protected String mId;
    protected int mState = 0;
    protected T mData;

    public void setNextState(int statesCount) {
        mState++;
        if (mState >= statesCount) {
            mState = 0;
        }
    }

    public DataListItem(String id) {
        mId = id;
    }

    public DataListItem(String id, T data) {
        mId = id;
        mData = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof DataListItem)) {
            DataListItem item = (DataListItem) obj;
            return EqualUtil.safeEqual(mId, item.getId())
                    && EqualUtil.safeEqual(mData, item.getData());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        int div = 31;
        result = div * result + (mId == null ? 0 : mId.hashCode());
        result = div * result + (mData == null ? 0 : mData.hashCode());
        return result;
    }

    public int getViewState() {
        return mState;
    }

    public String getId() {
        return mId;
    }

    public T getData() {
        return mData;
    }

    public int getType() {
        return DATA;
    }
}
