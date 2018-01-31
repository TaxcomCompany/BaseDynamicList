package ru.taxcom.mobile.android.basedynamiclist.model;


public interface BaseListItem {

    int HEADER = 0;
    int DATA = 1;
    int PROGRESS = 2;
    int ERROR = 3;

    int getType();
}
