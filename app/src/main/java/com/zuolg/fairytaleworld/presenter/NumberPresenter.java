package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.NumberView;
import com.zuolg.fairytaleworld.model.NumberModule;


public class NumberPresenter {
    /**
     * 绑定的view
     */
    private NumberView myView;
    /**
     * 绑定的Model
     */
    private NumberModule myModel;

    public NumberPresenter(NumberView view) {
        this.myView = view;
        myModel = new NumberModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}