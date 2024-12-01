package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 自定义适配器类，用于展示Item列表
 */
public class AdapterCur extends BaseAdapter {
    // Item列表
    List<Item> list;
    // 上下文环境
    Context context;

    /**
     * 构造函数，初始化适配器
     * @param context 上下文环境
     * @param list Item列表
     */
    public AdapterCur(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
        // 通知数据集发生变化，以触发界面更新
        notifyDataSetChanged();
    }

    /**
     * 获取当前列表的选项数量
     * @return 列表项的数量
     */
    public int getCount() {
        return list.size();
    }

    /**
     * 根据下标得到列表项
     * @param position 列表项的位置
     * @return 指定位置的Item对象
     */
    public Item getItem(int position) {
        return list.get(position);
    }

    /**
     * 获取列表项的ID
     * @param position 列表项的位置
     * @return 列表项的ID，本例中简单返回0
     */
    public long getItemId(int position) {
        return 0;
    }

    /**
     * 获取列表项的视图
     * @param position 列表项的位置
     * @param convertView 旧的视图，用于回收利用
     * @param parent 包含这个视图的父控件
     * @return 返回加载了数据的视图
     */
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        // 如果还没加载
        if (convertView == null) {
            // 加载布局文件，并将各个选项以及每个选项中的内容一一对应
            convertView = View.inflate(context, R.layout.checkbox_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageAndroid);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.textFigure);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 得到十六进制的颜色的int值
        int blue = Color.parseColor("#FF018786");
        int white = Color.parseColor("#FFFFFF");
        viewHolder.textView.setText(list.get(position).getName());
        // 如果被选中，那么改变选中颜色
        if (list.get(position).isSelected() == true) {
            viewHolder.textView.setBackgroundColor(blue);
            viewHolder.imageView.setBackgroundColor(blue);
        } else {
            viewHolder.textView.setBackgroundColor(white);
            viewHolder.imageView.setBackgroundColor(white);
        }
        return convertView;
    }

    /**
     * 创建内部类，定义每一个列表项所包含的东西，这里是每个列表项都有一个imageView和textView
     */
    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}

