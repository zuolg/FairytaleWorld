package com.zuolg.fairytaleworld.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.zuolg.fairytaleworld.R;

public class BaseActivity extends AppCompatActivity {

    /* 状态栏 */
    public SystemBarTintManager tintManager;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create our manager instance after the content view is set
        tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true);
        mContext = this;

    }

    /**
     * 设置状态栏
     *
     * @param res
     */
    public void setTintColor(int res) {
        tintManager.setTintColor(res);
        // set a custom navigation bar resource
        tintManager.setNavigationBarTintResource(res);
        // set a custom status bar drawable
        tintManager.setStatusBarTintColor(res);
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
     * @author ZuoLG
     * @time 2016/9/5 15:51
     */
    public void setTitle(Toolbar toolbar,int res) {
        toolbar.setTitle(res);
        setSupportActionBar(toolbar);
    }

}
