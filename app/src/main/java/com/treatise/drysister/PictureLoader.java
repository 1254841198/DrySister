package com.treatise.drysister;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PictureLoader {

    public static final int SUCCESS = 1;

    String imageUrl;
    ImageView imageView;
    byte[] picBytes;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == SUCCESS) {
                if (picBytes != null) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(picBytes, 0, picBytes.length);
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    };


    public void load(ImageView imageView, String url) {
        this.imageUrl = url;
        this.imageView = imageView;
        Drawable drawable = imageView.getDrawable();

        new Thread(runnable).start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
                connection.setRequestMethod("GET");
                connection.setReadTimeout(10000);
                if (connection.getResponseCode() == 200) {
                    InputStream in = connection.getInputStream();//获取输入流
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int length = -1;
                    while ((length = in.read(bytes)) != -1) {
                        out.write(bytes, 0, length);
                    }
                    picBytes = out.toByteArray();
                    in.close();
                    out.close();
                    handler.sendEmptyMessage(SUCCESS);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };
}
