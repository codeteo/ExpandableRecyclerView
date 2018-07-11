package com.expand.adapter;

import android.view.View;
import android.widget.TextView;

import com.expand.R;
import com.expand.models.Child;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by teo on 11/7/2018.
 */

public class MyChildViewHolder extends ChildViewHolder {

    private TextView textView;

    public MyChildViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_child_name);
    }

    public void onBind(Child child) {
        textView.setText(child.getName());
    }
}
