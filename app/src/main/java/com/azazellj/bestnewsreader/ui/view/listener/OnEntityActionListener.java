package com.azazellj.bestnewsreader.ui.view.listener;

import com.azazellj.bestnewsreader.entity.Entity;

/**
 * Created by azazellj on 3/2/16.
 */
public interface OnEntityActionListener<E extends Entity> {
    void OnClick(E entity);
}
