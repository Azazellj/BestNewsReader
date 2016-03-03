package com.azazellj.bestnewsreader.utils;

import android.util.TypedValue;

import com.azazellj.bestnewsreader.application.NewsApp;

/**
 * Created by azazellj on 3/3/16.
 */
public class Utils {
    public static int convertDpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, NewsApp.getAppContext().getResources().getDisplayMetrics());
    }
}
