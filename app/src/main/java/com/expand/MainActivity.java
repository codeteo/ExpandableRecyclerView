package com.expand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.expand.adapter.MyAdapter;
import com.expand.models.Parent;
import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import static com.expand.data.MyDataFactory.makeData;

/**
 * Created by teo on 11/7/2018.
 */

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAIN-ACTIVITY";

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAdapter();

        disableAnimation();

        adapter.setOnGroupExpandCollapseListener(new GroupExpandCollapseListener() {
            @Override
            public void onGroupExpanded(ExpandableGroup group) {
                adapter.toggleCheck(((Parent) group).getId());
            }

            @Override
            public void onGroupCollapsed(ExpandableGroup group) {
                adapter.toggleCheck(((Parent) group).getId());
            }
        });

    }

    private void setupAdapter() {
        recyclerView = findViewById(R.id.rv_main_list);

        adapter = new MyAdapter(makeData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void disableAnimation() {
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }

}