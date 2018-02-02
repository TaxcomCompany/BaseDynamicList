package ru.taxcom.mobile.android.basedynamiclist.model;


public class ProgressItem extends DataListItem {

    public ProgressItem() {
        super(null);
    }

    @Override
    public int getType() {
        return PROGRESS;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ProgressItem)) {
            return super.equals(obj);
        } else {
            return false;
        }
    }
}
