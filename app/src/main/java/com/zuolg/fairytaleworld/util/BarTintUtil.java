package com.zuolg.fairytaleworld.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * @author ZuoLangGuo
 * @time 2016/10/19 11:49
 */

public class BarTintUtil {

    /**
     * 设置状态栏
     *
     * @param res
     */
    public static SystemBarTintManager setTintColor(Activity activity, int res) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true);
        //设置颜色
        if (res != 0) {
            tintManager.setStatusBarTintResource(res);//通知栏所需颜色
        }
        return tintManager;
    }


    @TargetApi(19)
    private static void setTranslucentStatus(Activity activity, boolean on) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
