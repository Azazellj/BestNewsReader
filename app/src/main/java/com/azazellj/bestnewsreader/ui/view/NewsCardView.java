package com.azazellj.bestnewsreader.ui.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.azazellj.bestnewsreader.R;
import com.azazellj.bestnewsreader.application.NewsApp;
import com.azazellj.bestnewsreader.entity.news.NewsItem;
import com.azazellj.bestnewsreader.ui.view.listener.OnNewsActionListener;

import butterknife.ButterKnife;

/**
 * Created by azazellj on 3/2/16.
 */
public class NewsCardView extends CardView implements OnNewsActionListener<NewsItem> {
    private TextView mAgency;
    private TextView mHeadLine;
    private TextView mTimeStamp;
    private TextView mCroppedNewsText;
    private Button mShareButton;

    public NewsCardView(Context context) {
        this(context, null);
    }

    public NewsCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NewsCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.adapter_item_news, this);
        this.mAgency = ButterKnife.findById(this, R.id.agency_name);
        this.mHeadLine = ButterKnife.findById(this, R.id.head_line);
        this.mTimeStamp = ButterKnife.findById(this, R.id.news_time);
        this.mCroppedNewsText = ButterKnife.findById(this, R.id.croppedNewsText);
        this.mShareButton = ButterKnife.findById(this, R.id.share_news_button);
    }

    public void updateView(final NewsItem newsItem) {
        this.mAgency.setText(newsItem.Agency);
        this.mHeadLine.setText(newsItem.HeadLine);
        this.mTimeStamp.setText(newsItem.DateLine);
        this.mCroppedNewsText.setText(newsItem.Story.substring(0, 160).concat("..."));

        this.mShareButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                OnNewsShare(newsItem);
            }
        });
    }

    @Override
    public void OnClick(NewsItem newsItem) {
        Toast.makeText(NewsApp.getAppContext(), "Not yet implemented", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnNewsShare(NewsItem newsItem) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, newsItem.WebURL);
        Intent chooser = Intent.createChooser(shareIntent, "Choose an app");
        chooser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        NewsApp.getAppContext().startActivity(chooser);
    }
}
