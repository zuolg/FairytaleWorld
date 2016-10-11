package com.zuolg.fairytaleworld.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zuolg.fairytaleworld.R;
import com.zuolg.fairytaleworld.base.BaseActivity;
import com.zuolg.fairytaleworld.presenter.SettingsPresenter;
import com.zuolg.fairytaleworld.view.PoetryView;
import com.zuolg.fairytaleworld.presenter.PoetryPresenter;

import butterknife.ButterKnife;


/**
 * 诗词
 * @author ZuoLG
 * @time 2016/9/12 14:59
 */
public final class PoetryActivity extends Fragment implements PoetryView {
    /**
     * presenter对象
     */
    private PoetryPresenter presenter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_poetry, null);
        ButterKnife.bind(this, view);
        presenter = new PoetryPresenter(this);

        return view;
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
