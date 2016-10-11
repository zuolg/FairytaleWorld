package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.HomeView;
import com.zuolg.fairytaleworld.model.HomeModule;


public class HomePresenter {
    /**
     * 绑定的view
     */
    private HomeView myView;
    /**
     * 绑定的Model
     */
    private HomeModule myModel;

    public HomePresenter(HomeView view) {
        this.myView = view;
        myModel = new HomeModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}