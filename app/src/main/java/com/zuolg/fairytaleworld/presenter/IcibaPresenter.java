package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.IcibaView;
import com.zuolg.fairytaleworld.model.IcibaModule;


public class IcibaPresenter {
    /**
     * 绑定的view
     */
    private IcibaView myView;
    /**
     * 绑定的Model
     */
    private IcibaModule myModel;

    public IcibaPresenter(IcibaView view) {
        this.myView = view;
        myModel = new IcibaModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}