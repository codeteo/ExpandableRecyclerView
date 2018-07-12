package com.expand.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.expand.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by teo on 11/7/2018.
 */

public class MyParentViewHolder extends GroupViewHolder {

    public CheckBox checkBox;
    public TextView tvName;
    public int childCount;

    public MyParentViewHolder(View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cb_item_parent_check);
        tvName = itemView.findViewById(R.id.tv_item_parent_name);
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    public void setChildren(ExpandableGroup children) {
        checkBox.setText(children.getTitle());
    }

    public void setFavorite(boolean isFavorite) {
        checkBox.setChecked(isFavorite);
    }

}
