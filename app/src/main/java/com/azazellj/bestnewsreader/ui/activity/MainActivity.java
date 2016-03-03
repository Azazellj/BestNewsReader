package com.azazellj.bestnewsreader.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.azazellj.bestnewsreader.R;
import com.azazellj.bestnewsreader.adapter.NewsListAdapter;
import com.azazellj.bestnewsreader.api.retrofit.ApiManager;
import com.azazellj.bestnewsreader.entity.news.NewsItem;
import com.azazellj.bestnewsreader.entity.news.NewsList;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    protected List<NewsItem> mNewsItems;
    private NewsListAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = ButterKnife.findById(this, R.id.recycleView);
        mSwipeRefreshLayout = ButterKnife.findById(this, R.id.refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mNewsItems = new ArrayList<>();
        mNewsAdapter = new NewsListAdapter(mNewsItems);
        mRecyclerView.setAdapter(mNewsAdapter);
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);

        ApiManager.getInstance().getNews().enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                mNewsAdapter.setItems(response.body().NewsItem);
                mRecyclerView.swapAdapter(mNewsAdapter, false);
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
