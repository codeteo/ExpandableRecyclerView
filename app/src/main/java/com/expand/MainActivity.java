package com.expand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.expand.adapter.MyAdapter;

import static com.expand.data.MyDataFactory.makeData;

/**
 * Created by teo on 11/7/2018.
 */

public class MainActivity extends AppCompatActivity {

    String[] testgroupData =  {"Apple","Banana","Mango", "Orange", "Pineapple", "Strawberry"};
    String[] testChildData =  {"10","20","30", "40", "50", "10","20","30", "40",
            "50", "10","20","30", "40", "50", "10","20","30", "40", "50", "10","20","30", "40", "50"};

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_main_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(makeData()));
    }
}