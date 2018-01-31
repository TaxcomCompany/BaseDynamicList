package ru.taxcom.mobile.android.basedynamiclist.model;


public class ProgressItem implements BaseListItem{
    @Override
    public int getType() {
        return PROGRESS;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProgressItem && ((ProgressItem) obj).getType() == PROGRESS) {
            return true;
        } else {
            return false;
        }
    }
}
