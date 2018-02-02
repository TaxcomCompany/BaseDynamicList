package ru.taxcom.mobile.android.basedynamiclist.view;

import android.support.annotation.Nullable;
import java.util.List;

import ru.taxcom.mobile.android.basedynamiclist.model.DataListItem;
import ru.taxcom.mobile.android.basedynamiclist.model.ListData;

public interface DynamicListView<D extends ListData> {

    void showList(List<DataListItem<D>>  items);

    void clearList();

    void showEmpty(@Nullable String text);

    void hideEmpty();

    void showError(Throwable throwable);

    void hideError();

    void loadNextPageError(Throwable throwable);

    void loadNextPage(List<DataListItem<D>>  items);

    void showProgress();

    void hideProgress();

    String getSearchText();
}
