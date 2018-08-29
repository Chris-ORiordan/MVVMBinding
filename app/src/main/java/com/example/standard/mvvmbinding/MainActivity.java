package com.example.standard.mvvmbinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.view.View;

import com.example.standard.mvvmbinding.databinding.ActivityMainBinding;
import com.example.standard.mvvmbinding.viewmodel.*;

public class MainActivity extends AppCompatActivity {

    private DataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = bind();
        initRecyclerView(view);
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.setUp();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.tearDown();
    }

    private View bind() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new DataViewModel();
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

}
