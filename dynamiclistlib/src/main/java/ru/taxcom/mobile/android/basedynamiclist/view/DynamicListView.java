package ru.taxcom.mobile.android.basedynamiclist.view;

import android.support.annotation.Nullable;
import java.util.List;

import ru.taxcom.mobile.android.basedynamiclist.model.BaseListItem;

public interface DynamicListView<T extends BaseListItem> {

    void showList(List<T> items);

    void clearList();

    void showEmpty(@Nullable String text);

    void hideEmpty();

    void showError(Throwable throwable);

    void hideError();

    void loadNextPageError(Throwable throwable);

    void loadNextPage(List<T> items);

    void showProgress();

    void hideProgress();

    String getSearchText();
}
