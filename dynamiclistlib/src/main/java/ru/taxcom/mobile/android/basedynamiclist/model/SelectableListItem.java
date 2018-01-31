package ru.taxcom.mobile.android.basedynamiclist.model;


public class SelectableListItem extends DataListItem {

    protected String mName;
    protected boolean mSelected;

    public SelectableListItem(String name, String id, boolean selected) {
        mName = name;
        mId = id;
        mSelected = selected;
    }

    public void changeSelected(boolean isSelected) {
        mSelected = isSelected;
    }

    public String getName() {
        return mName;
    }

    public boolean isSelected() {
        return mSelected;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof SelectableListItem)) {
            SelectableListItem item = (SelectableListItem) obj;
            return safeFieldEquals(mId, item.getId())
                    && safeFieldEquals(mName, item.getName())
                    && mSelected == item.isSelected();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (mId == null ? 0 : mId.hashCode());
        result = prime * result + (mName == null ? 0 : mName.hashCode());
        result = 31 * result + (mSelected ? 1 : 0);
        return result;
    }
}
