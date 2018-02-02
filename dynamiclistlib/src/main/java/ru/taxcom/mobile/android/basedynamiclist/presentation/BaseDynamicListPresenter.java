package ru.taxcom.mobile.android.basedynamiclist.presentation;


import java.util.List;

import ru.taxcom.mobile.android.basedynamiclist.model.DataListItem;
import ru.taxcom.mobile.android.basedynamiclist.view.DynamicListView;

public abstract class BaseDynamicListPresenter<T extends  DynamicListView> implements DynamicListPresenter<T> {

    protected T mView;
    protected boolean mLoading = false;

    @Override
    public void bind(T view) {
        mView = view;
    }

    @Override
    public void loadNextPage() {
        // Переопределять при необходимости добавления динамической подгрузки
    }

    protected void handleSuccess(List<DataListItem> items) {
        mLoading = false;
        if (mView != null) {
            mView.hideProgress();
            if (isListEmpty(items)) {
                mView.showEmpty(null);
            } else {
                mView.showList(items);
            }
        }
    }

    protected void handleNextPage(List<DataListItem> items) {
        mLoading = false;
        if (mView != null) {
            mView.hideProgress();
            mView.loadNextPage(items);
        }
    }

    protected void handleError(Throwable throwable) {
        mLoading = false;
        if (mView != null) {
            mView.showError(throwable);
        }
    }

    protected void handleNextPageError(Throwable throwable) {
        mLoading = false;
        if (mView != null) {
            mView.hideProgress();
            mView.loadNextPageError(throwable);
        }
    }

    protected boolean isListEmpty(List<DataListItem> items) {
        return items.isEmpty() || (items.size() == 1 && items.get(0).getType() != DataListItem.DATA);
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
