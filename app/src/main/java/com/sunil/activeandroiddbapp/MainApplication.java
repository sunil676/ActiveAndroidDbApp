package com.sunil.activeandroiddbapp;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by sunil on 18-03-2017.
 */

public class MainApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
