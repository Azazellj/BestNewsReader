package com.azazellj.bestnewsreader.ui.view.listener;

import com.azazellj.bestnewsreader.entity.news.NewsItem;

/**
 * Created by azazellj on 3/3/16.
 */
public interface OnNewsActionListener<N extends NewsItem> extends OnEntityActionListener<N> {
    void OnNewsShare(N item);
}
