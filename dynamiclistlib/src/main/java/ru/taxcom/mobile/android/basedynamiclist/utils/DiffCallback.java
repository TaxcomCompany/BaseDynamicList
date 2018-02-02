package ru.taxcom.mobile.android.basedynamiclist.utils;

import android.support.v7.util.DiffUtil;

import java.util.List;

import ru.taxcom.mobile.android.basedynamiclist.model.DataListItem;

import static ru.taxcom.mobile.android.basedynamiclist.model.DataListItem.DATA;


public class DiffCallback extends DiffUtil.Callback {
    List<DataListItem> mOldItems;
    List<DataListItem> mNewItems;

    public DiffCallback(List<DataListItem> newItems, List<DataListItem> oldItems) {
        this.mNewItems = newItems;
        this.mOldItems = oldItems;
    }

    @Override
    public int getOldListSize() {
        return mOldItems.size();
    }

    @Override
    public int getNewListSize() {
        return mNewItems.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        DataListItem oldItem = mOldItems.get(oldItemPosition);
        DataListItem newItem = mNewItems.get(newItemPosition);
        if (oldItem.getType() == DATA && newItem.getType() == DATA) {
            return oldItem.getId().equals(newItem.getId());
        } else if (oldItem.getType() == newItem.getType()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldItems.get(oldItemPosition).equals(mNewItems.get(newItemPosition));
    }
}
