package ru.taxcom.mobile.android.basedynamiclist.presentation;


import ru.taxcom.mobile.android.basedynamiclist.view.DynamicListView;

public interface DynamicListPresenter<T extends  DynamicListView> {

    void bind(T view);

    void loadItems();

    void loadNextPage();

    void unbind();
}
