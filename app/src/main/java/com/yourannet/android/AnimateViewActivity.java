package com.yourannet.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yourannet.android.cusview.DemoSurfaceView;

/**
 * Created by lvjunwei on 2017/8/24.
 */
public class AnimateViewActivity extends Activity {

    private DemoSurfaceView cu_sv;
    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new AnimateView(this));
        setContentView(R.layout.activity_cus_surfaceview);
        cu_sv = (DemoSurfaceView)findViewById(R.id.cus_sv);
        cu_sv.setZOrderOnTop(true);      // 这句不能少
        cu_sv.getHolder().setFormat(PixelFormat.TRANSPARENT);
        btn_test = (Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cu_sv.refreshSelf();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
/*    class AnimateView extends View {
        float radius = 10;
        Paint paint;

        public AnimateView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.translate(200, 200);
            canvas.drawCircle(200, 200, radius++, paint);
            if (radius > 100) {
                radius = 10;
            }
            invalidate();//通过调用这个方法让系统自动刷新视图
        }

    }*/

}