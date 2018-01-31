package ru.taxcom.mobile.android.basedynamiclist.presentation;


import java.util.List;

import ru.taxcom.mobile.android.basedynamiclist.model.BaseListItem;
import ru.taxcom.mobile.android.basedynamiclist.view.DynamicListView;

public abstract class BaseDynamicListPresenter implements DynamicListPresenter {

    protected DynamicListView mView;
    protected boolean mLoading = false;

    @Override
    public void bind(DynamicListView view) {
        mView = view;
    }

    @Override
    public void loadNextPage() {
        // Переопределять при необходимости добавления динамической подгрузки
    }

    protected void handleSuccess(List<BaseListItem> items) {
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

    protected void handleNextPage(List<BaseListItem> items) {
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

    protected boolean isListEmpty(List<BaseListItem> items) {
        return items.isEmpty() || (items.size() == 1 && items.get(0).getType() != BaseListItem.DATA);
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
