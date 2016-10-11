package com.z.andutil.adapter;

import android.content.Context;
import android.text.Spanned;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 公共的ViewHolder
 */
public class ViewHolderM {
    private SparseArray<View> viewArray;
    private int position;
    private View mConvertView;
    private Object tag;

    /**
     * 构造方法
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     */
    public ViewHolderM(Context context, View convertView, ViewGroup parent,
                       int layoutId, int position) {
        this.position = position;
        //使用SparseArray效率高一些
        viewArray = new SparseArray<View>();
        //加载布局
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        //将ViewHolderM赋值给View的Tag
        mConvertView.setTag(this);
    }

    public static ViewHolderM get(Context context, View convertView,
                                  ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            //如果convertView为空，则实例化ViewHolderM
            return new ViewHolderM(context, convertView, parent, layoutId, position);
        } else {
            //否则从convertView的Tag中取出ViewHolderM，避免重复创建
            ViewHolderM holder = (ViewHolderM) convertView.getTag();
            holder.position = position;
            return holder;
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * 通过viewId获取控件对象
     *
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = viewArray.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            viewArray.put(viewId, view);
        }
        return (T) view;
    }


    /**------------------------------------华丽的分割线------------------------------------*/
    /**以下方法为额外封装的方法，只是简单几个，以后可以慢慢完善*/


    /**
     * 设置TextView的内容
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolderM setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置TextView的内容
     *
     * @param viewId
     * @param text，Spanned类型，可设置部分字体变色
     * @return
     */
    public ViewHolderM setText(int viewId, Spanned text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置图片的可见性
     *
     * @param viewId
     * @param visible
     * @return
     */
    public ViewHolderM setImageViewVisible(int viewId, Boolean visible) {
        ImageView iv = getView(viewId);
        if (visible) {
            iv.setVisibility(View.VISIBLE);
        } else {
            iv.setVisibility(View.GONE);
        }
        return this;
    }
}