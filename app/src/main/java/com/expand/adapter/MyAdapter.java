package com.expand.adapter;

import android.util.Log;
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

    public static final String TAG = "MY-ADAPTER";

    private List<Parent> groups;

    public MyAdapter(List<Parent> groups) {
        super(groups);
        this.groups = groups;
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
        final Child child = (Child) group.getItems().get(childIndex);
        ((MyChildViewHolder) holder).onBind(child);
    }

    @Override
    public void onBindGroupViewHolder(MyParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        if (groups.get(flatPosition).isFavorite()) {
            Log.i(TAG, "onBindGroupViewHolder TRUE");
            holder.setFavorite(true);
        } else {
            Log.i(TAG, "onBindGroupViewHolder FALSE");
            holder.setFavorite(false);
        }
        holder.setChildren(group);
    }

    public void toggleCheck(int id) {
        Parent parent = null;
        for (Parent p: groups){
            if (p.getId() == id) {
                if (p.isFavorite()) {
                    p.setFavorite(false);
                } else {
                    p.setFavorite(true);
                }
                break;
            }
        }
        notifyDataSetChanged();
    }

}
