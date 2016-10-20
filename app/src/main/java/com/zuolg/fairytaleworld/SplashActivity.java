package com.zuolg.fairytaleworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.zuolg.fairytaleworld.baiduspeech.BaiduSpeechDataUtil;
import com.zuolg.fairytaleworld.base.BaseActivity;
import com.zuolg.fairytaleworld.global.AppConst;
import com.zuolg.fairytaleworld.view.impl.HomeActivity;

/**
 * 预先加载数据的SplashActivity ,启动界面
 * @author ZuoLG
 * @time 2016/9/3 16:59
 */
public class SplashActivity extends BaseActivity {
    private static final int SHOW_TIME_MIN = 1200;// 最小显示时间
    private static final int RUN_1 = 0x01;// 最小显示时间
    private long mStartTime;// 开始时间

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case RUN_1:// 如果城市列表加载完毕，就发送此消息
                    long loadingTime = System.currentTimeMillis() - mStartTime;// 计算一下总共花费的时间
                    if (loadingTime < SHOW_TIME_MIN) {// 如果比最小显示时间还短，就延时进入MainActivity，否则直接进入
                        mHandler.postDelayed(finishActivity, SHOW_TIME_MIN
                                - loadingTime);
                    } else {
                        mHandler.post(finishActivity);
                    }
                    break;
                default:
                    break;
            }
        }
    };
    //进入下一个Activity
    Runnable finishActivity = new Runnable() {

        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this,
                    HomeActivity.class));
            finish();
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        mStartTime = System.currentTimeMillis();//记录开始时间，
        //开始加载数据
        BaiduSpeechDataUtil baiduSpeechDataUtil = new BaiduSpeechDataUtil(SplashActivity.this, AppConst.BAIDU_APIKEY,AppConst.BAIDU_SECRET,AppConst.BAIDU_APPID);
        mHandler.sendEmptyMessage(RUN_1);
    }
}