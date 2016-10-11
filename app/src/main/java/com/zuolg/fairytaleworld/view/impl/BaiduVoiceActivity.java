package com.zuolg.fairytaleworld.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.z.andutil.util.T;
import com.zuolg.fairytaleworld.R;
import com.zuolg.fairytaleworld.baiduvoice.BaiduVoiceHelper;
import com.zuolg.fairytaleworld.base.BaseActivity;
import com.zuolg.fairytaleworld.presenter.BaiduVoicePresenter;
import com.zuolg.fairytaleworld.presenter.LetterPresenter;
import com.zuolg.fairytaleworld.view.BaiduVoiceView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 百度语音识别
 * @author ZuoLG
 * @time 2016/9/12 14:57
 */
public final class BaiduVoiceActivity extends Fragment implements BaiduVoiceView {
    @BindView(R.id.button_voice)
    Button buttonVoice;

    //百度语音识别
    private static final String BAI_DU_DEMO_APIKEY = "ChhCvMgUlhXrD9aSGjZnOnys";
    private static final String BAI_DU_DEMO_SECRET = "0cab035bd9243f8111e57ee96a654c9f";
    private static final int REQUEST_UI = 1;

    /**
     * presenter对象
     */
    private BaiduVoicePresenter presenter;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_baidu_voice, null);
        ButterKnife.bind(this, view);
        presenter = new BaiduVoicePresenter(this);



        return view;
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


    @OnClick(R.id.button_voice)
    public void onClick() {
        /*T.show(mContext,"12123132");
        //点击开启百度语音识别
        BaiduVoiceHelper.startBaiduVoiceDialogForResult(BaiduVoiceActivity.this, BAI_DU_DEMO_APIKEY, BAI_DU_DEMO_SECRET, REQUEST_UI);*/

    }
}
