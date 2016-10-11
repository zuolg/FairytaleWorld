package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.SettingsView;
import com.zuolg.fairytaleworld.model.SettingsModule;


public class SettingsPresenter {
    /**
     * 绑定的view
     */
    private SettingsView myView;
    /**
     * 绑定的Model
     */
    private SettingsModule myModel;

    public SettingsPresenter(SettingsView view) {
        this.myView = view;
        myModel = new SettingsModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}