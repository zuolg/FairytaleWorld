package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.ShareView;
import com.zuolg.fairytaleworld.model.ShareModule;


public class SharePresenter {
    /**
     * 绑定的view
     */
    private ShareView myView;
    /**
     * 绑定的Model
     */
    private ShareModule myModel;

    public SharePresenter(ShareView view) {
        this.myView = view;
        myModel = new ShareModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}