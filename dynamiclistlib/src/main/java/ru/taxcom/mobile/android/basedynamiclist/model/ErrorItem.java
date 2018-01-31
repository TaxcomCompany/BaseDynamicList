package ru.taxcom.mobile.android.basedynamiclist.model;

public class ErrorItem implements BaseListItem {

    @Override
    public int getType() {
        return ERROR;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ErrorItem && ((ErrorItem) obj).getType() == ERROR) {
            return true;
        } else {
            return false;
        }
    }
}
