package com.azazellj.bestnewsreader.entity.news;

import com.azazellj.bestnewsreader.entity.Entity;

/**
 * Created by azazellj on 3/1/16.
 */
public class NewsItem extends Entity {
    public long NewsItemId;
    public String HeadLine;
    public String Agency;
    public String DateLine;
    public String WebURL;
    public String Caption;
    public String Keywords;
    public String Story;
    public String CommentCountUrl;
    public String CommentFeedUrl;
    public String Related;
    public String ByLine;
    public Image Image;

    public NewsItem() {
        super();
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NewsItem)) {
            return false;
        }

        return NewsItemId == ((NewsItem) o).NewsItemId;
    }
}

class Image {
    public String Photo;
    public String Thumb;
    public String PhotoCaption;
}
