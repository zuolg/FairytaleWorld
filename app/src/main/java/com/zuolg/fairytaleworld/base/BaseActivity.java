package com.zuolg.fairytaleworld.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class BaseActivity extends AppCompatActivity {


    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

    }



    /**
     * 设置app头
     *
     * @author ZuoLG
     * @time 2016/9/5 15:47
     */
    public void setTitle(Toolbar toolbar, String res) {

        toolbar.setTitle(res);
        setSupportActionBar(toolbar);
    }

    /**
     * 设置头int
     *
     * @author ZuoLG
     * @time 2016/9/5 15:51
     */
    public void setTitle(Toolbar toolbar, int res) {
        toolbar.setTitle(res);
        setSupportActionBar(toolbar);
    }

}
