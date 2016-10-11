package com.zuolg.fairytaleworld.presenter;

import com.zuolg.fairytaleworld.view.LetterView;
import com.zuolg.fairytaleworld.model.LetterModule;


public class LetterPresenter {
    /**
     * 绑定的view
     */
    private LetterView myView;
    /**
     * 绑定的Model
     */
    private LetterModule myModel;

    public LetterPresenter(LetterView view) {
        this.myView = view;
        myModel = new LetterModule();
    }

    /**
     * 加载
     */
    public void onLoad() {

    }

}