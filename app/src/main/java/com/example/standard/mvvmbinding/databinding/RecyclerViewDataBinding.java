package com.example.standard.mvvmbinding.databinding;

import android.databinding.*;
import android.support.v7.widget.RecyclerView;

import com.example.standard.mvvmbinding.adapter.DataAdapter;
import com.example.standard.mvvmbinding.datamodel.DataModel;

import java.util.List;

public class RecyclerViewDataBinding {
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, DataAdapter dataAdapter, List<DataModel> data){
        recyclerView.setAdapter(dataAdapter);
        dataAdapter.updateData(data);
    }
}
