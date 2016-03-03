package com.azazellj.bestnewsreader.api.service;

import com.azazellj.bestnewsreader.entity.Entity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by azazellj on 3/1/16.
 */
public interface IndiaTimeService<E extends Entity> {
    //
    //      http://timesofindia.indiatimes.com/feeds/newsdefaultfeeds.cms?feedtype=sjson
    //

    @GET("feeds/newsdefaultfeeds.cms?feedtype=sjson")
    Call<E> getNews();
}
