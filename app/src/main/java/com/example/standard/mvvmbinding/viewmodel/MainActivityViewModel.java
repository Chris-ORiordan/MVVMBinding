package com.example.standard.mvvmbinding.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.*;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.standard.mvvmbinding.datamodel.DataModel;

public class MainActivityViewModel extends BaseObservable {
    private DataModel dataModel;

    public MainActivityViewModel(DataModel dataModel){
        this.dataModel = dataModel;
    }

    public void setUp() {
        // perform set up tasks, such as adding listeners
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public String getTitle(){
        return !TextUtils.isEmpty(dataModel.getTitle()) ? dataModel.getTitle() : "";
    }
}
