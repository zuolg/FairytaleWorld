package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.BaiduVoiceView;
import com.zuolg.fairytaleworld.model.BaiduVoiceModule;


public class BaiduVoicePresenter {
    /**
     * 绑定的view
     */
    private BaiduVoiceView myView;
    /**
     * 绑定的Model
     */
    private BaiduVoiceModule myModel;

    public BaiduVoicePresenter(BaiduVoiceView view) {
        this.myView = view;
        myModel = new BaiduVoiceModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}