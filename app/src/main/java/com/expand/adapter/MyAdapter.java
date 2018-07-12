package com.expand.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.expand.R;
import com.expand.helpers.OnChooseItemListener;
import com.expand.models.Child;
import com.expand.models.Parent;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by teo on 11/7/2018.
 */

public class MyAdapter extends CheckableChildRecyclerViewAdapter<MyParentViewHolder, MyChildViewHolder> {

    public static final String TAG = "MY-ADAPTER";

    private List<Parent> dataset;
    private Set<Integer> positionSet;
    private OnChooseItemListener listener;
    private Map<Integer, MyParentViewHolder> groupMap;
    private Map<Integer, Integer> childChecksMap;

    public MyAdapter(List<Parent> groups, OnChooseItemListener listener) {
        super(groups);
        this.dataset = groups;
        this.listener = listener;
        this.positionSet = new HashSet<>();
        groupMap = new HashMap<>();
        childChecksMap = new HashMap<>( );
    }

    @Override
    public MyParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parent, parent, false);

        MyParentViewHolder holder = new MyParentViewHolder(view);
        return holder;
    }

    @Override
    public MyChildViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_child, parent, false);
        return new MyChildViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(MyChildViewHolder holder, int flatPosition, CheckedExpandableGroup group, int childIndex) {
        holder.setName(((Child)group.getItems().get(childIndex)).getName());

        int adapterChildPos = getRealChildAdapterPosition(group, childIndex);
        if (positionSet.contains(adapterChildPos)) {
            if (!holder.getCheckable().isChecked()) {
                holder.getCheckable().setChecked(true);
            }
        } else {
            holder.getCheckable().setChecked(false);
        }

        holder.checkBox.setOnClickListener(v -> {
            CheckBox cb = (CheckBox) v;
            if (adapterChildPos > 0) {
                int realGroupPos = getRealGroupPosition(group);
                MyParentViewHolder parentVH = groupMap.get(realGroupPos);

                if (cb.isChecked()) {
                    positionSet.add(adapterChildPos);
                    listener.onSelect(adapterChildPos);

                    if (parentVH != null) {
                        int childCheckCount = childChecksMap.get(realGroupPos);
                        if (childCheckCount < parentVH.childCount) {
                            childCheckCount++;
                        }
                        childChecksMap.put(realGroupPos, childCheckCount);

                        if (childChecksMap.get(realGroupPos) == parentVH.childCount) {
                            parentVH.checkBox.setChecked(true);
                            int adapterGroupPos = getAdapterPositionByRealGroupPosition(realGroupPos);
                            positionSet.add(adapterGroupPos);
                        }
                    }
                } else {
                    positionSet.remove(adapterChildPos);
                    listener.onDeselect(adapterChildPos);

                    if (parentVH != null) {
                        parentVH.checkBox.setChecked(false);
                        int adapterGroupPos = getAdapterPositionByRealGroupPosition(realGroupPos);
                        positionSet.remove(adapterGroupPos);

                        int childCheckCount = childChecksMap.get(realGroupPos);
                        if (childCheckCount > 0) {
                            childCheckCount--;
                        }
                        childChecksMap.put(realGroupPos, childCheckCount);
                    }
                }
            }
        });

    }

    @Override
    public void onBindGroupViewHolder(MyParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setName(group.getTitle());

        int realGroupPos = getRealGroupPosition(group);
        if (realGroupPos >= 0) {
            holder.childCount = group.getItemCount();
            groupMap.put(realGroupPos, holder);
            if (!childChecksMap.containsKey(realGroupPos)) {
                childChecksMap.put(realGroupPos, 0);
            }

            int adapterGroupPos = getAdapterPositionByRealGroupPosition(realGroupPos);
            if (positionSet.contains(adapterGroupPos)) {
                if (!holder.checkBox.isChecked()) {
                    holder.checkBox.setChecked(true);
                }
            } else {
                holder.checkBox.setChecked(false);
            }
        }

        holder.checkBox.setOnClickListener(v -> {
            CheckBox cb = (CheckBox) v;
            if (realGroupPos >= 0) {
                int adapterGroupPos = getAdapterPositionByRealGroupPosition(realGroupPos);

                MyParentViewHolder groupViewHolder = groupMap.get(realGroupPos);

                if (cb.isChecked()) {
                    positionSet.add(adapterGroupPos);
                    childChecksMap.put(realGroupPos, groupViewHolder.childCount);
                } else {
                    positionSet.remove(adapterGroupPos);
                    childChecksMap.put(realGroupPos, 0);
                }

                for (int i = 0; i < group.getItemCount(); i++) {
                    checkChild(cb.isChecked(), realGroupPos, i);

                    int adapterChildPos = adapterGroupPos + i + 1;
                    if (cb.isChecked()) {
                        positionSet.add(adapterChildPos);
                        listener.onSelect(adapterChildPos);
                    } else {
                        positionSet.remove(adapterChildPos);
                        listener.onDeselect(adapterChildPos);
                    }
                }
            }
        });

    }

    private int getRealGroupPosition(ExpandableGroup group) {
        for (int i = 0; i < dataset.size(); i++) {
            Parent parent = dataset.get(i);
            if (parent.getTitle().equals(group.getTitle())
                    && parent.getChildIDs().size() == group.getItemCount()) {
                return i;
            }
        }
        return -1;
    }

    private int getAdapterPositionByRealGroupPosition(int realGroupPosition) {
        int count = realGroupPosition;
        for (int i = 0; i < realGroupPosition; i++) {
            count += dataset.get(i).getItemCount();
        }
        return count;
    }

    private int getRealChildAdapterPosition(ExpandableGroup group, int childIndex) {
        int realGroupPos = getRealGroupPosition(group);
        if (realGroupPos >= 0) {
            int adapterGroupPos = getAdapterPositionByRealGroupPosition(realGroupPos);
            return adapterGroupPos + childIndex + 1;
        }
        return -1;
    }

}
