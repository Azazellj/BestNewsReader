package com.azazellj.bestnewsreader.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by azazellj on 3/1/16.
 */
public class NewsApp extends Application {
    private static Context mContext;

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

}
