package com.yourannet.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.yourannet.android.adapter.TestListViewAdapter;
import com.yourannet.android.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5.
 */
public class ListViewWithGrid extends Activity {

    private ListView listview;
    private TestListViewAdapter listViewAdapter ;
    private List<TestBean> listBean;
    private String imgs1;
    private String imgs2;
    private String imgs3;
    private String imgs4;
    private String imgs5;
    private String imgs6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_grid);
        listBean=new ArrayList<TestBean>();
        initView();
        initData();
    }

    private void initView() {
        listview=(ListView) findViewById(R.id.listview);

    }

    private void initData() {
		/*
		 * 添加模拟数据，正常情况下，这些数据是从服务端获取的
		 * 此次添加了七条数据，对应Gridview中图片数量
		 */
        //模拟用户发布的图片，路径用"#"隔开
        imgs1="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58";
        imgs2="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58";
        imgs3="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58";
        imgs4="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58";
        imgs5="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58#http://t11.baidu.com/it/u=2722915642,3232472693&fm=58";
        imgs6="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58#http://t11.baidu.com/it/u=2722915642,3232472693&fm=58#http://t12.baidu.com/it/u=1313963321,225077119&fm=58";

        TestBean bean=null;
        for(int i=0;i<7;i++){
            bean=new TestBean();
            switch (i) {
                case 0:
                    bean.setUsername("白玉梁");
                    bean.setHeadphoto("http://avatar.csdn.net/3/B/9/1_baiyuliang2013.jpg");
                    bean.setContent("欢迎关注本人博客：http://blog.csdn.net/baiyuliang2013");
                    bean.setTime("1分钟前");
                    break;
                case 1:
                    bean.setUsername("刘德华");
                    bean.setHeadphoto("http://t10.baidu.com/it/u=2565424359,3856609610&fm=58");
                    bean.setContent("大家好，我是刘德华");
                    bean.setTime("3分钟前");
                    bean.setImages(imgs1);
                    break;
                case 2:
                    bean.setUsername("张学友");
                    bean.setHeadphoto("http://t10.baidu.com/it/u=374721516,1427740298&fm=58");
                    bean.setContent("大家好，我是张学友");
                    bean.setTime("5分钟前");
                    bean.setImages(imgs2);
                    break;
                case 3:
                    bean.setUsername("郭富城");
                    bean.setHeadphoto("http://t11.baidu.com/it/u=3158457091,3429860559&fm=58");
                    bean.setContent("大家好，我是郭富城");
                    bean.setTime("1小时前");
                    bean.setImages(imgs3);
                    break;
                case 4:
                    bean.setUsername("黎明");
                    bean.setHeadphoto("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
                    bean.setContent("大家好，我是黎明");
                    bean.setTime("2小时前");
                    bean.setImages(imgs4);
                    break;
                case 5:
                    bean.setUsername("金城武");
                    bean.setHeadphoto("http://t11.baidu.com/it/u=2722915642,3232472693&fm=58");
                    bean.setContent("大家好，我是金城武");
                    bean.setTime("昨天");
                    bean.setImages(imgs5);
                    break;
                case 6:
                    bean.setUsername("古天乐");
                    bean.setHeadphoto("http://t12.baidu.com/it/u=1313963321,225077119&fm=58");
                    bean.setContent("大家好，我是古天乐");
                    bean.setTime("前天");
                    bean.setImages(imgs6);
                    break;
            }
            listBean.add(bean);//添加进list
        }

        listViewAdapter=new TestListViewAdapter(this, listBean);
        listview.setAdapter(listViewAdapter);
        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Toast.makeText(ListViewWithGrid.this, "点击了第"+(arg2+1)+"项", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
