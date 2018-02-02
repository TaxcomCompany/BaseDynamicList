package ru.taxcom.mobile.android.basedynamiclist.view;

import android.support.annotation.Nullable;
import java.util.List;

import ru.taxcom.mobile.android.basedynamiclist.model.DataListItem;

public interface DynamicListView {

    void showList(List<DataListItem> items);

    void clearList();

    void showEmpty(@Nullable String text);

    void hideEmpty();

    void showError(Throwable throwable);

    void hideError();

    void loadNextPageError(Throwable throwable);

    void loadNextPage(List<DataListItem> items);

    void showProgress();

    void hideProgress();

    String getSearchText();
}
