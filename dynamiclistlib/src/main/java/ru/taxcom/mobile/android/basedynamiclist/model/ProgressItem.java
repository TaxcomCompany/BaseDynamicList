package ru.taxcom.mobile.android.basedynamiclist.model;


public class ProgressItem implements BaseListItem{
    @Override
    public Type getType() {
        return Type.PROGRESS;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProgressItem && ((ProgressItem) obj).getType() == Type.PROGRESS) {
            return true;
        } else {
            return false;
        }
    }
}
