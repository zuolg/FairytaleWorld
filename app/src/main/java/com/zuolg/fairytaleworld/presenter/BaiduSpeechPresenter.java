package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.BaiduSpeechView;
import com.zuolg.fairytaleworld.model.BaiduSpeechModule;


public class BaiduSpeechPresenter {
    /**
     * 绑定的view
     */
    private BaiduSpeechView myView;
    /**
     * 绑定的Model
     */
    private BaiduSpeechModule myModel;

    public BaiduSpeechPresenter(BaiduSpeechView view) {
        this.myView = view;
        myModel = new BaiduSpeechModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}