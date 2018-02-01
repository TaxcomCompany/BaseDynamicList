package ru.taxcom.mobile.android.basedynamiclist.model;

import android.support.annotation.NonNull;

public class ErrorItem extends DataListItem<StringData> {

    public ErrorItem(@NonNull String id) {
        super(id);
    }

    public ErrorItem(@NonNull String id, StringData data) {
        super(id, data);
    }

    @Override
    public int getType() {
        return ERROR;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ErrorItem)) {
            return super.equals(obj);
        } else {
            return false;
        }
    }
}
