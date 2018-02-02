package ru.taxcom.mobile.android.basedynamiclist.presentation;


import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import ru.taxcom.mobile.android.basedynamiclist.model.DataListItem;
import ru.taxcom.mobile.android.basedynamiclist.model.ErrorItem;
import ru.taxcom.mobile.android.basedynamiclist.model.ProgressItem;
import ru.taxcom.mobile.android.basedynamiclist.utils.DiffCallback;

import static ru.taxcom.mobile.android.basedynamiclist.model.DataListItem.DATA;

public abstract class DynamicListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<DataListItem> mItems;
    protected int mDataItemStates = 1;
    protected OnItemClickListener mItemClickListener;
    protected OnItemExpandClickListener mItemExpandListener;

    public DynamicListAdapter() {
        mItems = new ArrayList<>();
    }

    public void setItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void setItemExpandListener(OnItemExpandClickListener listener) {
        mItemExpandListener = listener;
    }

    public void setDataItemStates(int stateCount) {
        mDataItemStates = stateCount;
    }

    public void expandItems(int position) {
        if (mDataItemStates > 1) {
            List<DataListItem> oldItems = new ArrayList<>(mItems);
            if (position == -1) {
                for (DataListItem item : mItems) {
                    if (item.getType() == DATA) {
                        item.setNextState(mDataItemStates);
                    }
                }
            } else {
                DataListItem item = mItems.get(position);
                if (item.getType() == DATA) {
                    item.setNextState(mDataItemStates);
                }
            }
            showUpdatedItems(oldItems);
        }
    }

    public void update(List<DataListItem> items) {
        if (items != null) {
            List<DataListItem> oldItems = new ArrayList<>(mItems);
            mItems.clear();
            mItems.addAll(items);
            showUpdatedItems(oldItems);
        }
    }

    public void showProgress() {
        if (mItems.isEmpty() || (mItems.get(mItems.size()-1).getType() != DataListItem.PROGRESS)) {
            List<DataListItem> oldItems = new ArrayList<>(mItems);
            mItems.add(new ProgressItem());
            showUpdatedItems(oldItems);
        }
    }

    public void hideProgress() {
        int lastPosition = mItems.size() - 1;
        if (!mItems.isEmpty() && mItems.get(lastPosition).getType() == DataListItem.PROGRESS) {
            List<DataListItem> oldItems = new ArrayList<>(mItems);
            mItems.remove(lastPosition);
            showUpdatedItems(oldItems);
        }
    }

    public void showErrorItem() {
        if (mItems.isEmpty() || (mItems.get(mItems.size()-1).getType() != DataListItem.ERROR)) {
            List<DataListItem> oldItems = new ArrayList<>(mItems);
            mItems.add(new ErrorItem());
            showUpdatedItems(oldItems);
        }
    }

    public void hideErrorItem() {
        int lastPosition = mItems.size() - 1;
        if (!mItems.isEmpty() && mItems.get(lastPosition).getType() == DataListItem.ERROR) {
            List<DataListItem> oldItems = new ArrayList<>(mItems);
            mItems.remove(lastPosition);
            showUpdatedItems(oldItems);
        }
    }

    public void addPage(List<DataListItem> items) {
        if (items != null) {
            List<DataListItem> oldItems = new ArrayList<>(mItems);
            mItems.addAll(items);
            showUpdatedItems(oldItems);
        }
    }

    public void clearList() {
        List<DataListItem> oldItems = new ArrayList<>(mItems);
        mItems.clear();
        showUpdatedItems(oldItems);
    }

    protected void showUpdatedItems(List<DataListItem> oldData) {
        final DiffCallback diffCallback = new DiffCallback(oldData, mItems);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemViewType(int position) {
        if (!mItems.isEmpty()) {
            return mItems.get(position).getType();
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public interface OnItemClickListener {
        void onItemClick(DataListItem item);
    }

    public interface OnItemExpandClickListener {
        void onClick(DataListItem item);
    }
}
