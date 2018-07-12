package com.expand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.expand.adapter.MyAdapter;
import com.expand.helpers.OnChooseItemListener;

import java.util.HashSet;
import java.util.Set;

import static com.expand.data.MyDataFactory.makeData;

/**
 * Created by teo on 11/7/2018.
 */

public class MainActivity extends AppCompatActivity implements OnChooseItemListener {

    public static final String TAG = "MAIN-ACTIVITY";

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    private Set<Integer> selectedPositionsSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAdapter();

        disableAnimation();

        selectedPositionsSet = new HashSet<>();

    }

    private void setupAdapter() {
        recyclerView = findViewById(R.id.rv_main_list);

        adapter = new MyAdapter(makeData(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void disableAnimation() {
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }

    @Override
    public void onSelect(int position) {
        selectedPositionsSet.add(position);
    }

    @Override
    public void onDeselect(int position) {
        selectedPositionsSet.remove(position);
    }

}