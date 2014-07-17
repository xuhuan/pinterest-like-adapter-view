package com.huewu.pla.app;

import android.os.Handler;
import android.view.Menu;

import com.huewu.pla.lib.MultiColumnPullToRefreshListView;
import com.huewu.pla.lib.MultiColumnPullToRefreshListView.OnRefreshListener;
import com.huewu.pla.app.internal.ImgResource;

public class PullToRefreshSampleActivity extends SampleActivity {

    private MultiColumnPullToRefreshListView mPullToRefreshListView = null;

    @Override
    protected void init() {
        setContentView(R.layout.act_pull_to_refresh_sample);
        mPullToRefreshListView = (MultiColumnPullToRefreshListView) findViewById(R.id.list);
        mWaterfallView = mPullToRefreshListView;
        initUIAction();
        mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.update(ImgResource.genData());
                mAdapter.notifyDataSetInvalidated();
                //5秒后完成
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshListView.onRefreshComplete();
                    }
                }, 5000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

}//end of class
