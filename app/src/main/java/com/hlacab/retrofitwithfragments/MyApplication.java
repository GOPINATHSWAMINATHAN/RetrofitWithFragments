package com.hlacab.retrofitwithfragments;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * Created by gopinath on 29/01/18.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
