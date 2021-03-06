package com.yourannet.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_hello)
    TextView tvHello;
    @BindView(R.id.cus_surface_view)
    Button cusSurfaceView;
    @BindView(R.id.cus_list_grid_view)
    Button cusListGridView;
    @BindView(R.id.related_list_view)
    Button relatedListView;
    @BindView(R.id.btn_chart_view)
    Button btnChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Logger logger = LoggerFactory.getLogger(MainActivity.class);
        logger.info("onCreate is called . ");
        logger.error("onCreate error is called . ");
    }

    @OnClick(R.id.tv_hello)
    public void onViewClicked() {
        Toast.makeText(this, "Hello world !", Toast.LENGTH_LONG).show();
    }

    @OnClick({R.id.btn_chart_view,R.id.cus_surface_view, R.id.cus_list_grid_view, R.id
            .related_list_view})
    public void onViewClicked(View view) {
        Intent it = new Intent();
        switch (view.getId()) {
            case R.id.btn_chart_view:
                it.setClass(MainActivity.this, ChartViewActivity.class);
                break;
            case R.id.cus_surface_view:
                it.setClass(MainActivity.this, AnimateViewActivity.class);
                break;
            case R.id.cus_list_grid_view:
                it.setClass(MainActivity.this, ListViewWithGrid.class);
                break;
            case R.id.related_list_view:
                it.setClass(MainActivity.this, RelatedListActivity.class);
                break;
        }
        MainActivity.this.startActivity(it);
    }

}
