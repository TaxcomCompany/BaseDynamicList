package ru.taxcom.mobile.android.basedynamiclist.model;


public class HeaderItem extends DataListItem<StringData> {

    public HeaderItem() {
        super(null);
    }

    public HeaderItem(StringData data) {
        super(null, data);
    }

    @Override
    public int getType() {
        return HEADER;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof HeaderItem)) {
            return super.equals(obj);
        } else {
            return false;
        }
    }
}
