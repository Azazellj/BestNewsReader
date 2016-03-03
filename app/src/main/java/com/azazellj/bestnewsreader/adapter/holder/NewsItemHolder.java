package com.azazellj.bestnewsreader.adapter.holder;

import android.content.Context;

import com.azazellj.bestnewsreader.entity.news.NewsItem;
import com.azazellj.bestnewsreader.ui.view.NewsCardView;

/**
 * Created by azazellj on 3/2/16.
 */


public class NewsItemHolder extends BaseListItemViewHolder<NewsItem, NewsCardView> {
    private NewsCardView mView;

    public NewsItemHolder(Context context) {
        this(new NewsCardView(context));
    }

    public NewsItemHolder(NewsCardView newsCardView) {
        super(newsCardView);
        this.mView = newsCardView;
    }

    public NewsCardView getView() {
        return this.mView;
    }

    public void updateView(NewsItem newsItem) {
        this.mView.updateView(newsItem);
    }
}
