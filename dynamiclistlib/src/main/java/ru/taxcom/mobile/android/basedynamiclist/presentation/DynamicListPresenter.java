package ru.taxcom.mobile.android.basedynamiclist.presentation;


import ru.taxcom.mobile.android.basedynamiclist.view.DynamicListView;

public interface DynamicListPresenter {

    void bind(DynamicListView view);

    void loadItems();

    void loadNextPage();

    void unbind();
}
