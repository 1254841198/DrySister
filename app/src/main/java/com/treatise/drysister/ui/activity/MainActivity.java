package com.treatise.drysister.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.treatise.drysister.loader.PictureLoader;
import com.treatise.drysister.R;
import com.treatise.drysister.network.SisterApi;
import com.treatise.drysister.bean.entity.Sister;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button changeSister;
    Button changePage;

    ArrayList<String> urls;
    PictureLoader loader;
    SisterApi sisterApi;

    int currentIndex = 0;//当前哪一张
    int page = 1;
    private AsyncTask<Void, Void, Sister> sisterAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initData() {
        loader = new PictureLoader();
        sisterApi = new SisterApi();
        urls = new ArrayList<>();
//        urls.add("http://ww4.sinaimg.cn/large/610dc034jw1f6ipaai7wgj20dw0kugp4.jpg");
//        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f6gcxc1t7vj20hs0hsgo1.jpg");
//        urls.add("http://ww4.sinaimg.cn/large/610dc034jw1f6f5ktcyk0j20u011hacg.jpg");
//        urls.add("http://ww1.sinaimg.cn/large/610dc034jw1f6e1f1qmg3j20u00u0djp.jpg");
//        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f6aipo68yvj20qo0qoaee.jpg");
//        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f69c9e22xjj20u011hjuu.jpg");
//        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f689lmaf7qj20u00u00v7.jpg");
//        urls.add("http://ww3.sinaimg.cn/large/c85e4a5cjw1f671i8gt1rj20vy0vydsz.jpg");
//        urls.add("http://ww2.sinaimg.cn/large/610dc034jw1f65f0oqodoj20qo0hntc9.jpg");
//        urls.add("http://ww2.sinaimg.cn/large/c85e4a5cgw1f62hzfvzwwj20hs0qogpo.jpg");

        new SisterAsyncTask(page).execute();
    }

    private void initView() {
        imageView = findViewById(R.id.imageView);
        changeSister = findViewById(R.id.changeImage);
        changePage = findViewById(R.id.changePage);

        changePage.setOnClickListener(this);
        changeSister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.changeImage: {
                currentIndex++;
                if (currentIndex >= urls.size()) {
                    currentIndex = currentIndex % urls.size();
                }
                loader.load(imageView, urls.get(currentIndex));
                Log.d("network", "onClick: " + urls.get(currentIndex));
            }
            break;
            case R.id.changePage: {
                page++;
                currentIndex = 0;
                new SisterAsyncTask(page).execute();
                loader.load(imageView, urls.get(currentIndex));
            }
            break;
        }
    }

    private class SisterAsyncTask extends AsyncTask<Void, Void, Sister> {

        int page;

        @Override
        protected Sister doInBackground(Void... voids) {
            if (isCancelled()) {
                return null;
            }
            return sisterApi.accessSister(page, 10);
        }

        public SisterAsyncTask(int page) {
            this.page = page;
        }

        @Override
        protected void onPostExecute(Sister sister) {
            super.onPostExecute(sister);
            if (sister == null) {
                Log.e(SisterApi.TAG, "onPostExecute: " + "数据为空");
                return;
            }
            ArrayList<Sister.Data> dataArrayList = sister.getDataArrayList();
            if (dataArrayList == null || dataArrayList.size() <= 0) {
                return;
            }
            Log.d("network", "onPostExecute:dataArrayList = " + dataArrayList.size());
            urls.clear();
            for (Sister.Data data : dataArrayList) {
                urls.add(data.getImages());
            }
        }
    }
}
