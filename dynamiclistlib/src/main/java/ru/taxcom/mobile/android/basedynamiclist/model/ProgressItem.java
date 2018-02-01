package ru.taxcom.mobile.android.basedynamiclist.model;


import android.support.annotation.NonNull;

public class ProgressItem extends DataListItem {

    public ProgressItem(@NonNull String id) {
        super(id);
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
