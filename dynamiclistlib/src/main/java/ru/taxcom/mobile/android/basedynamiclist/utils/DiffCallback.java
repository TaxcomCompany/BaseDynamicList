package ru.taxcom.mobile.android.basedynamiclist.utils;

import android.support.v7.util.DiffUtil;

import java.util.List;

import ru.taxcom.mobile.android.basedynamiclist.model.BaseListItem;
import ru.taxcom.mobile.android.basedynamiclist.model.DataListItem;
import ru.taxcom.mobile.android.basedynamiclist.model.HeaderItem;


public class DiffCallback extends DiffUtil.Callback {
    List<BaseListItem> mOldItems;
    List<BaseListItem> mNewItems;

    public DiffCallback(List<BaseListItem> newItems, List<BaseListItem> oldItems) {
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
        if (mOldItems.get(oldItemPosition) instanceof DataListItem
                && mNewItems.get(newItemPosition) instanceof DataListItem) {
            DataListItem oldItem = (DataListItem) mOldItems.get(oldItemPosition);
            DataListItem newItem = (DataListItem) mNewItems.get(newItemPosition);
            return oldItem.getId().equals(newItem.getId());
        } else if (mOldItems.get(oldItemPosition) instanceof HeaderItem
                && mNewItems.get(newItemPosition) instanceof HeaderItem) {
            HeaderItem oldItem = (HeaderItem) mOldItems.get(oldItemPosition);
            HeaderItem newItem = (HeaderItem) mNewItems.get(newItemPosition);
            return oldItem.equals(newItem);
        } else if (mOldItems.get(oldItemPosition).getType() != BaseListItem.DATA &&
                mOldItems.get(oldItemPosition).getType() == mNewItems.get(newItemPosition).getType()) {
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
