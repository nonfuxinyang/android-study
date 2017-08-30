package com.yourannet.android;

import android.app.Application;

import com.czzdit.commons.utils.UtilTypeface;

/**
 * Created by lvjunwei on 2017/8/30.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilTypeface.replaceSystemDefaultFont(this,"fonts/lishu.ttf");
    }
}
