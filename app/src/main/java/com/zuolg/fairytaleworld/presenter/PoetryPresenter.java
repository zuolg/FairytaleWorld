package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.PoetryView;
import com.zuolg.fairytaleworld.model.PoetryModule;


public class PoetryPresenter {
    /**
     * 绑定的view
     */
    private PoetryView myView;
    /**
     * 绑定的Model
     */
    private PoetryModule myModel;

    public PoetryPresenter(PoetryView view) {
        this.myView = view;
        myModel = new PoetryModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}