package com.huewu.pla.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.MultiColumnListView.OnLoadMoreListener;
import com.huewu.pla.sample.internal.ImageWrapper;
import com.huewu.pla.sample.internal.ImgResource;
import com.lurencun.android.adapter.ConvertViewAdapter;
import com.lurencun.android.adapter.ViewBuilderDelegate;
import com.lurencun.android.system.ActivityUtility;

public class SampleActivity extends Activity implements ViewBuilderDelegate<ImageWrapper>{

    public static final int PULL_TO_REFRESH_ID = 1008611;
    protected MultiColumnListView mWaterfallView = null;

    // 其它例子Activity共用
    protected ConvertViewAdapter<ImageWrapper> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected void init() {
        setContentView(R.layout.act_sample);
        mWaterfallView = (MultiColumnListView) findViewById(R.id.list);
        initUIAction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, PULL_TO_REFRESH_ID, 0, "启动<下拉刷新瀑布流>示例");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == PULL_TO_REFRESH_ID) {
            Intent intent = new Intent(this, PullToRefreshSampleActivity.class);
            startActivity(intent);
        }
        return true;
    }

    protected void initUIAction() {
        mAdapter = new ConvertViewAdapter<ImageWrapper>(getLayoutInflater(), this);
        mWaterfallView.setAdapter(mAdapter);
        mAdapter.update(ImgResource.genData());
        mWaterfallView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mAdapter.add(ImgResource.genData());
                mAdapter.notifyDataSetChanged();
                ActivityUtility.show(SampleActivity.this, "到List底部自动加载更多数据");
                //5秒后完成
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mWaterfallView.onLoadMoreComplete();
                    }
                }, 5000);
            }
        });
    }

    @Override
    public View newView(LayoutInflater layoutInflater, ImageWrapper data) {
        View view = layoutInflater.inflate(R.layout.item_sample, null);
        return view;
    }

    @Override
    public void bindView(View view, int position, ImageWrapper data) {
        ImageView image = (ImageView) view.findViewById(R.id.thumbnail);
        TextView text = (TextView) view.findViewById(R.id.text);
        text.setText("W=" + data.width + ", H=" + data.height + ", ID=" + String.valueOf(data.id));

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) image.getLayoutParams();
        params.width = data.width;
        params.height = data.height;
        image.setLayoutParams(params);
        image.setAdjustViewBounds(false);
        image.setBackgroundColor((int) (0xFF555555 + data.id * 255 * 24));
        image.setImageResource(data.res);
        image.invalidate();
    }

    @Override
    public void releaseView(View view, ImageWrapper data) {}
}//end of class
