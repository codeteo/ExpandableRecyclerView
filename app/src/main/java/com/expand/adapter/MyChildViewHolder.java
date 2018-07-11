package com.expand.adapter;

import android.support.v7.widget.AppCompatCheckedTextView;
import android.view.View;
import android.widget.Checkable;

import com.expand.R;
import com.expand.models.Child;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

/**
 * Created by teo on 11/7/2018.
 */

public class MyChildViewHolder extends CheckableChildViewHolder {

    private AppCompatCheckedTextView textView;

    public MyChildViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_item_child_name);
    }

    @Override
    public Checkable getCheckable() {
        return textView;
    }

    public void onBind(Child child) {
        textView.setText(child.getName());
    }
}
