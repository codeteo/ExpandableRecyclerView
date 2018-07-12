package com.expand.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

import com.expand.R;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

/**
 * Created by teo on 11/7/2018.
 */

public class MyChildViewHolder extends CheckableChildViewHolder {

    public CheckBox checkBox;
    public TextView tvName;

    public MyChildViewHolder(View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cb_item_child_check);
        tvName = itemView.findViewById(R.id.tv_item_child_name);
    }

    @Override
    public Checkable getCheckable() {
        return checkBox;
    }

    public void setName(String name) {
        tvName.setText(name);
    }
}
