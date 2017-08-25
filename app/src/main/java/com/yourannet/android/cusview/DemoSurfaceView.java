package com.yourannet.android.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * Created by lvjunwei on 2017/8/24.
 */
public class DemoSurfaceView extends SurfaceView implements Callback {

    private static final String TAG = "DemoSurfaceView";

    LoopThread thread;

    public DemoSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DemoSurfaceView(Context context) {
        super(context);

    }

    public void refreshSelf() {
        init(); //初始化,设置生命周期回调方法
        thread.isRunning = true;
        thread.start();
        this.invalidate();
    }

    private void init() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this); //设置Surface生命周期回调
        thread = new LoopThread(holder, getContext());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {// 当SurfaceView被显示时会调用，需要再这边开启绘制的线程

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {// 当SurfaceView被隐藏会销毁时调用的方法，在这里你可以关闭绘制的线程
        thread.isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行绘制的绘制线程
     *
     * @author Administrator
     */
    class LoopThread extends Thread {
        SurfaceHolder surfaceHolder;
        Context context;
        boolean isRunning;
        float radius = 10f;
        Paint paint;

        public LoopThread(SurfaceHolder surfaceHolder, Context context) {
            this.surfaceHolder = surfaceHolder;
            this.context = context;
            isRunning = false;
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth((float) 10.0);
        }

        @Override
        public void run() {
            Canvas c = null;
            while (isRunning) {
                try {
                    synchronized (surfaceHolder) {
                        c = surfaceHolder.lockCanvas(null);
                        doDraw(c);
                        //通过它来控制帧数执行一次绘制后休息500ms
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    surfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }

        public void doDraw(Canvas c) {
            //这个很重要，清屏操作，清楚掉上次绘制的残留图像
            c.drawColor(Color.YELLOW);
            c.translate(200, 200);
            c.drawCircle(0, 0, radius++, paint);
            if (radius > 100) {
                radius = 10f;
            }
        }

    }

}