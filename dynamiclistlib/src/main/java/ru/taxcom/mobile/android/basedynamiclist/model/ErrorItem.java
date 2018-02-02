package ru.taxcom.mobile.android.basedynamiclist.model;


public class ErrorItem extends DataListItem<StringData> {

    public ErrorItem() {
        super(null);
    }

    public ErrorItem(StringData data) {
        super(null, data);
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
