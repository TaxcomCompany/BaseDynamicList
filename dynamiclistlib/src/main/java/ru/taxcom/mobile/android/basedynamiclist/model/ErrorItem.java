package ru.taxcom.mobile.android.basedynamiclist.model;

public class ErrorItem implements BaseListItem {

    @Override
    public Type getType() {
        return Type.ERROR;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ErrorItem && ((ErrorItem) obj).getType() == Type.ERROR) {
            return true;
        } else {
            return false;
        }
    }
}
