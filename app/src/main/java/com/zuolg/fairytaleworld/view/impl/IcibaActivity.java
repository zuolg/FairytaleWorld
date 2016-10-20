package com.zuolg.fairytaleworld.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zuolg.fairytaleworld.R;
import com.zuolg.fairytaleworld.presenter.IcibaPresenter;
import com.zuolg.fairytaleworld.util.BarTintUtil;
import com.zuolg.fairytaleworld.view.IcibaView;

import butterknife.BindView;
import butterknife.ButterKnife;


public final class IcibaActivity extends AppCompatActivity implements IcibaView {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    /**
     * presenter对象
     */
    private IcibaPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarTintUtil.setTintColor(this, R.color.colorPrimary);
        setContentView(R.layout.activity_iciba);
        ButterKnife.bind(this);
        presenter = new IcibaPresenter(this);
        mToolbar.setTitle("xxxxxxxxxxxxxxxxxxxxxxxxx");
        setSupportActionBar(mToolbar);




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
