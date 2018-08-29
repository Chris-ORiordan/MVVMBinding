package com.example.standard.mvvmbinding.databinding;

import android.databinding.DataBindingComponent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;

public class AppDataBindingComponent implements android.databinding.DataBindingComponent {
    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding(){
        return new RecyclerViewDataBinding();
    }
}
