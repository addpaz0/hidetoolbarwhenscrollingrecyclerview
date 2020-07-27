package com.example.hidetoolbarwhenscrollingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<String> mList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private FloatingActionButton mActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setUpView();
        fakeData();
        setUpRecyclerView();
        showHideWhenScroll();
    }
    
    private void setUpView() {
        mRecyclerView =  findViewById(R.id.recycler_view);
        mActionButton =  findViewById(R.id.fab);
        Toolbar toolbarr = findViewById(R.id.toolbar);

        setSupportActionBar(toolbarr);
    }

    private void fakeData() {
        Random random = new Random();
        for (int i = 0; i < 100; i++)
            mList.add(String.valueOf(random.nextInt(100)));
    }

    private void setUpRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager
                .VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        ListAdapter listAdapter = new ListAdapter(mList);
        mRecyclerView.setAdapter(listAdapter);
    }

    private void showHideWhenScroll() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) mActionButton.hide();
                else mActionButton.show();
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}