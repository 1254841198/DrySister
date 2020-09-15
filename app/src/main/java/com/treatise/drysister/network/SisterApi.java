package com.treatise.drysister.network;

import android.util.Log;

import com.treatise.drysister.bean.entity.Sister;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SisterApi {

    public static final String TAG = "network";

    //https://gank.io/api/v2/data/category/Girl/type/Girl/page/1/count/10
    public Sister accessSister(int page, int count) {
        String url = "https://gank.io/api/v2/data/category/Girl/type/Girl/page/" + page + "/count/" + count;

        Log.d(TAG, "accessSister: url = " + url);

        String result = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);

            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();
                ByteArrayOutputStream out = new ByteArrayOutputStream();

                byte[] bytes = new byte[1024];
                int length = -1;
                while ((length = in.read(bytes)) != -1) {
                    out.write(bytes, 0, length);
                }
                byte[] data = out.toByteArray();
                out.close();
                in.close();
                result = new String(data, "UTF-8");
            } else {
                //Toast不能在线程中使用
//                Toast.makeText(MyApplication.getContext(), "访问失败", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "accessSister: " +"访问失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Sister(result);
    }
}
