package com.expand.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.expand.R;
import com.expand.models.Child;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by teo on 11/7/2018.
 */

public class MyAdapter extends ExpandableRecyclerViewAdapter<MyParentViewHolder, MyChildViewHolder> {


    public MyAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public MyParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_parent, parent, false);
        return new MyParentViewHolder(view);
    }

    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_child, parent, false);
        return new MyChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(MyChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Child child = (Child) group.getItems().get(childIndex);
        ((MyChildViewHolder) holder).onBind(child);
    }

    @Override
    public void onBindGroupViewHolder(MyParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setChildren(group);
    }
}
