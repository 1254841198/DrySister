package com.treatise.drysister;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public static Application mApplication;
    public static Context mContext;

    @Override
    protected void attachBaseContext(Context base)
    {
        mContext = this;
        mApplication = this;
        super.attachBaseContext(base);
    }

    public static Context getContext(){
        return mContext;
    }
}
