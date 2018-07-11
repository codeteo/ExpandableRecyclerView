package com.expand.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.expand.R;
import com.expand.models.Child;
import com.expand.models.Parent;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by teo on 11/7/2018.
 */

public class MyAdapter extends CheckableChildRecyclerViewAdapter<MyParentViewHolder, MyChildViewHolder> {

    public MyAdapter(List<Parent> groups) {
        super(groups);
    }

    @Override
    public MyParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parent, parent, false);
        return new MyParentViewHolder(view);
    }

    @Override
    public MyChildViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_child, parent, false);
        return new MyChildViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(MyChildViewHolder holder, int flatPosition, CheckedExpandableGroup group, int childIndex) {
        final Child child = (Child) group.getItems().get(childIndex);
        ((MyChildViewHolder) holder).onBind(child);
    }

    @Override
    public void onBindGroupViewHolder(MyParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setChildren(group);
    }

}
