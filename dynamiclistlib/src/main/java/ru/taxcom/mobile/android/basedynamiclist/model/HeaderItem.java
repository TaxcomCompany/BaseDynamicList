package ru.taxcom.mobile.android.basedynamiclist.model;


public class HeaderItem implements BaseListItem {
    @Override
    public Type getType() {
        return Type.HEADER;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HeaderItem && ((HeaderItem) obj).getType() == Type.HEADER) {
            return true;
        } else {
            return false;
        }
    }
}
