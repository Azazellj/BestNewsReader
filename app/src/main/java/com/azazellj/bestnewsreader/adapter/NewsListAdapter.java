package com.azazellj.bestnewsreader.adapter;

import android.view.ViewGroup;

import com.azazellj.bestnewsreader.adapter.holder.NewsItemHolder;
import com.azazellj.bestnewsreader.entity.news.NewsItem;
import com.azazellj.bestnewsreader.ui.view.NewsCardView;

import java.util.List;

/**
 * Created by azazellj on 3/1/16.
 */
public class NewsListAdapter extends BaseListAdapter<NewsItem, NewsCardView, NewsItemHolder> {
    @Override
    public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsItemHolder(parent.getContext());
    }

    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {
        holder.updateView(getItem(position));
    }

    public NewsListAdapter(List<NewsItem> mDataSet) {
        setItems(mDataSet);
    }
}
