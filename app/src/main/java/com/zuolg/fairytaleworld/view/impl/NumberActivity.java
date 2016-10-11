package com.zuolg.fairytaleworld.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.andutil.util.T;
import com.zuolg.fairytaleworld.R;
import com.zuolg.fairytaleworld.adapter.ItemAdapter;
import com.zuolg.fairytaleworld.baiduspeech.BaiduSpeechUtil;
import com.zuolg.fairytaleworld.global.AppConst;
import com.zuolg.fairytaleworld.presenter.NumberPresenter;
import com.zuolg.fairytaleworld.view.NumberView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 * 数字
 * @author ZuoLG
 * @time 2016/9/12 14:59
 */
public final class NumberActivity extends Fragment implements NumberView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    /**
     * presenter对象
     */
    private NumberPresenter presenter;

    private BaiduSpeechUtil speechUtil;


    private ItemAdapter mAdapter;
    private ArrayList<String> items = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_number, null);
        ButterKnife.bind(this, view);
        presenter = new NumberPresenter(this);
        speechUtil = new BaiduSpeechUtil(getContext(), AppConst.BAIDU_APIKEY,AppConst.BAIDU_SECRET,AppConst.BAIDU_APPID);

        initView();

        return view;
    }

    private void initView() {
        //列数为两列
        int spanCount = 3;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),spanCount);

        recyclerView.setLayoutManager(gridLayoutManager);
        //String[] strs = new String[]{"0","1","2","3","4","5","6","7","8","9","+","-"};
        String[] strs = new String[]{"+","-","9","8","7","6","5","4","3","2","1","0"};
        //构建一个临时数据源
        for (int i = 0; i < strs.length; i++) {
            items.add(strs[i]);
        }
        mAdapter = new ItemAdapter(items,R.color.khaki);
        mAdapter.setOnItemClickListener(new ItemAdapter.OnRecyclerViewItemClickListener(){
            @Override
            public void onItemClick(View view , String data){
                speechUtil.speak(data);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onLoad() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onReset() {

    }

    @Override
    public void onCommit() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }


}
