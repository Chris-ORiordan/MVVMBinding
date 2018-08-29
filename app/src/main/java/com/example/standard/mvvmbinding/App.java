package com.example.standard.mvvmbinding;

import android.app.Application;
import android.databinding.*;

import com.example.standard.mvvmbinding.databinding.AppDataBindingComponent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
