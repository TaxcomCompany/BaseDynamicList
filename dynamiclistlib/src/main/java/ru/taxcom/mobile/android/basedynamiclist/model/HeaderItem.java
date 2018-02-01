package ru.taxcom.mobile.android.basedynamiclist.model;


import android.support.annotation.NonNull;

public class HeaderItem extends DataListItem<StringData> {

    public HeaderItem(@NonNull String id) {
        super(id);
    }

    public HeaderItem(@NonNull String id, StringData data) {
        super(id, data);
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
