package ru.taxcom.mobile.android.basedynamiclist.presentation;


import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import ru.taxcom.mobile.android.basedynamiclist.model.BaseListItem;
import ru.taxcom.mobile.android.basedynamiclist.model.DataListItem;
import ru.taxcom.mobile.android.basedynamiclist.model.ErrorItem;
import ru.taxcom.mobile.android.basedynamiclist.model.ProgressItem;
import ru.taxcom.mobile.android.basedynamiclist.utils.DiffCallback;

public abstract class DynamicListAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<BaseListItem> mItems;
    protected int mDataItemStates = 1;
    protected OnItemClickListener<T> mItemClickListener;
    protected OnItemExpandClickListener<T> mItemExpandListener;

    public DynamicListAdapter() {
        mItems = new ArrayList<>();
    }

    public void setItemClickListener(OnItemClickListener<T> listener) {
        mItemClickListener = listener;
    }

    public void setItemExpandListener(OnItemExpandClickListener<T> listener) {
        mItemExpandListener = listener;
    }

    public void setDataItemStates(int stateCount) {
        mDataItemStates = stateCount;
    }

    public void expandItems(int position) {
        if (mDataItemStates > 1) {
            List<BaseListItem> oldItems = new ArrayList<>(mItems);
            if (position == -1) {
                for (BaseListItem item : mItems) {
                    if (item instanceof DataListItem) {
                        ((DataListItem) item).setNextState(mDataItemStates);
                    }
                }
            } else {
                BaseListItem item = mItems.get(position);
                if (item instanceof DataListItem) {
                    ((DataListItem) item).setNextState(mDataItemStates);
                }
            }
            showUpdatedItems(oldItems);
        }

    }

    public void update(List<BaseListItem> items) {
        if (items != null) {
            List<BaseListItem> oldItems = new ArrayList<>(mItems);
            mItems.clear();
            mItems.addAll(items);
            showUpdatedItems(oldItems);
        }
    }

    public void showProgress() {
        List<BaseListItem> oldItems = new ArrayList<>(mItems);
        mItems.add(new ProgressItem());
        showUpdatedItems(oldItems);
    }

    public void hideProgress() {
        int lastPosition = mItems.size() - 1;
        if (!mItems.isEmpty() && mItems.get(lastPosition).getType() == BaseListItem.Type.PROGRESS) {
            List<BaseListItem> oldItems = new ArrayList<>(mItems);
            mItems.remove(lastPosition);
            showUpdatedItems(oldItems);
        }
    }

    public void showErrorItem() {
        List<BaseListItem> oldItems = new ArrayList<>(mItems);
        mItems.add(new ErrorItem());
        showUpdatedItems(oldItems);
    }

    public void hideErrorItem() {
        int lastPosition = mItems.size() - 1;
        if (!mItems.isEmpty() && mItems.get(lastPosition).getType() == BaseListItem.Type.ERROR) {
            List<BaseListItem> oldItems = new ArrayList<>(mItems);
            mItems.remove(lastPosition);
            showUpdatedItems(oldItems);
        }
    }

    public void addPages(List<BaseListItem> items) {
        if (items != null) {
            List<BaseListItem> oldItems = new ArrayList<>(mItems);
            mItems.addAll(items);
            showUpdatedItems(oldItems);
        }
    }

    public void clearList() {
        List<BaseListItem> oldItems = new ArrayList<>(mItems);
        mItems.clear();
        showUpdatedItems(oldItems);
    }

    protected void showUpdatedItems(List<BaseListItem> oldData) {
        final DiffCallback diffCallback = new DiffCallback(oldData, mItems);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(T data);
    }

    public interface OnItemExpandClickListener<T> {
        void onClick(T data);
    }
}
