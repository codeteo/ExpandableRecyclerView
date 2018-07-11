package com.expand.adapter;

import android.view.View;
import android.widget.TextView;

import com.expand.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by teo on 11/7/2018.
 */

public class MyParentViewHolder extends GroupViewHolder {

    private TextView textView;

    public MyParentViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_item_parent_name);
    }

    public void setChildren(ExpandableGroup children) {
        textView.setText(children.getTitle());
    }
}
