package ru.taxcom.mobile.android.basedynamiclist.model;


public interface BaseListItem {

    enum Type {
        HEADER,
        PROGRESS,
        ERROR,
        DATA
    }

    Type getType();
}
