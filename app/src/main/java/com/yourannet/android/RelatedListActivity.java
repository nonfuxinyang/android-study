package com.yourannet.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvjunwei on 2017/9/8.
 */
public class RelatedListActivity extends Activity {

    List<Map<String, Object>> mData;//定义一个List集合存储数据
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_list);
        listView = (ListView) findViewById(R.id.pro_lv);
        mData = getData();//获取数据
        MyAdapter adapter = new MyAdapter(this);//适配器
        listView.setAdapter(adapter);
    }

    //填充数据
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();//Map集合填充数据

        String exlist_adapter = "1234";
        map.put("exlist_adapter", exlist_adapter);
        map.put("zhuanchang", "美妆专场");
        map.put("info", "兰蔻最新季护肤套装");
        map.put("img", R.mipmap.pro);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("exlist_adapter", exlist_adapter);
        map.put("zhuanchang", "数码专场");
        map.put("info", "GooGle智能眼镜");
        map.put("img", R.mipmap.pp);
        list.add(map);//将map集合添加到list集合中

        map = new HashMap<String, Object>();
        map.put("exlist_adapter", exlist_adapter);
        map.put("zhuanchang", "美食专场");
        map.put("info", "小鸡炖蘑菇成了热议");
        map.put("img", R.mipmap.pro);
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("exlist_adapter", exlist_adapter);
        map.put("zhuanchang", "生活专场");
        map.put("info", "这个问题挺难");
        map.put("img", R.mipmap.pp);
        list.add(map);
        return list;
    }
    /**
     * 自定义适配器
     * @author bin
     *
     */
    private class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyAdapter(Activity mainActivity) {
            mInflater = LayoutInflater.from(mainActivity);
        }

        @Override
        public int getCount() {
            return mData.size();//List集合数据的长度
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_produces, null);//填充布局
                holder = new ViewHolder();
                holder.iv_produce = (ImageView) convertView.findViewById(R.id.iv_produce);
                holder.tv_pro_all = (TextView) convertView.findViewById(R.id.tv_pro_all);
//				holder.tv_control = (TextView) convertView.findViewById(R.id.tv_control);
                holder.tv_prod_info = (TextView) convertView.findViewById(R.id.tv_prod_info);
//				holder.tv_baoming = (TextView) convertView.findViewById(R.id.tv_baoming);
                //需要点击的单写
                final TextView tv_control = (TextView) convertView.findViewById(R.id.tv_control);
                final TextView tv_baoming = (TextView) convertView.findViewById(R.id.tv_baoming);
                final ListView listmore = (ListView) convertView
                        .findViewById(R.id.lv_more_list);//展开的布局

                tv_control.setOnClickListener(new View.OnClickListener() {
                    boolean isOpened = false;//改变展开状态
                    @Override
                    public void onClick(View v) {
                        if (!isOpened) {
                            listmore.setVisibility(View.VISIBLE);
                            tv_control.setText("收起");
                            isOpened = true;
                        }else {
                            listmore.setVisibility(View.GONE);
                            tv_control.setText("展开更多");
                            isOpened = false;
                        }

                    }
                });
                tv_baoming.setOnClickListener(new View.OnClickListener() {//报名按钮

                    @Override
                    public void onClick(View v) {

                    }
                });

//				//展开的布局
//				LinearLayout rlayout = new LinearLayout(convertView.getContext());
//				rlayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//				rlayout.setOrientation(LinearLayout.VERTICAL);
//				layout.addView(rlayout);
//
//				ImageView iv_line = new ImageView(convertView.getContext());
//				iv_line.setBackgroundResource(R.drawable.ic_launcher);
//				rlayout.addView(iv_line);
//				TextView tv_group = new TextView(convertView.getContext());
//				tv_group.setText("这里是这一类商品的ListView。");
//				rlayout.addView(tv_group);

//				ListView lv = new ListView(getApplicationContext());
//
//				lv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//				layout.addView(lv);
//				Madapter madapter = new Madapter(getApplicationContext());
//				lv.setAdapter(madapter);
                Madapter madapter = new Madapter(getApplicationContext());

                listmore.setAdapter(madapter);
                setListViewHeightBasedOnChildren(listmore);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            //填充数据
            holder.iv_produce.setBackgroundResource((Integer) mData.get(position).get(
                    "img"));
            holder.tv_pro_all.setText((String) mData.get(position).get("zhuanchang"));
            holder.tv_prod_info.setText((String) mData.get(position).get("info"));
            return convertView;
        }
    }

    /**
     * 适配器二
     * @author bin
     *
     */
    public class Madapter extends BaseAdapter{
        private LayoutInflater mInflater;
        public Madapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_more, null);
                holder = new ViewHolder();
                holder.iv_more = (ImageView) convertView.findViewById(R.id.iv_more);
                holder.tv_more_info = (TextView) convertView.findViewById(R.id.tv_more_info);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            //填充数据
            holder.iv_more.setBackgroundResource((Integer) mData.get(position).get(
                    "img"));
            System.out.println("------position-------"+position);
            System.out.println("-------mData.size()------"+mData.size());
            holder.tv_more_info.setText((String) mData.get(position).get("info"));
            return convertView;
        }
    }

    Madapter madapter;
    //定义一个函数将dp转换为像素
    public int Dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 动态设置ListView的宽度
     * @param listView
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10); // 可删除
        listView.setLayoutParams(params);
    }

    private final class ViewHolder {
        public ImageView iv_produce,iv_more;
        public TextView tv_pro_all,tv_prod_info,tv_more_info;
    }

}
