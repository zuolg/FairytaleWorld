package com.zuolg.fairytaleworld.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.z.andutil.util.T;
import com.zuolg.fairytaleworld.R;
import com.zuolg.fairytaleworld.baiduspeech.BaiduSpeechUtil;
import com.zuolg.fairytaleworld.global.AppConst;
import com.zuolg.fairytaleworld.presenter.BaiduSpeechPresenter;
import com.zuolg.fairytaleworld.view.BaiduSpeechView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 百度语音朗读
 *
 * @author ZuoLG
 * @time 2016/9/7 14:07
 */
public final class BaiduSpeechActivity extends Fragment implements BaiduSpeechView {
    @BindView(R.id.button_voice)
    Button buttonVoice;
    /**
     * presenter对象
     */
    private BaiduSpeechPresenter presenter;

    private BaiduSpeechUtil speechUtil;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_baidu_speech, null);
        presenter = new BaiduSpeechPresenter(this);
        ButterKnife.bind(this, view);

        speechUtil = new BaiduSpeechUtil(getContext(), AppConst.BAIDU_APIKEY,AppConst.BAIDU_SECRET,AppConst.BAIDU_APPID);

        return view;
    }



    //点击读
    @OnClick(R.id.button_voice)
    public void onClick() {
        T.show(getContext(),"00000000000000000000000");
        speechUtil.speak("文字文字文字文字文字文字文字文字文字");

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
