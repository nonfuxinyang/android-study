package com.yourannet.android;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lvjunwei on 2017/8/28.
 */
public class TypefaceActivity extends Activity {

    @BindView(R.id.tv_type_face)
    TextView tvTypeFace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeface);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/STHeiti-Light.ttc");
        tvTypeFace.setTypeface(font);//设置字体
        tvTypeFace.setText("移动产品部");
    }
}
