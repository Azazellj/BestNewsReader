package com.azazellj.bestnewsreader.api.retrofit;

import com.azazellj.bestnewsreader.api.service.IndiaTimeService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by azazellj on 3/3/16.
 */
public class ApiManager {
    private static IndiaTimeService mService;

    public static IndiaTimeService getInstance() {
        if (mService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://timesofindia.indiatimes.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mService = retrofit.create(IndiaTimeService.class);
        }

        return mService;
    }
}
