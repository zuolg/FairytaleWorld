package com.z.andutil.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


/**
 * 对话框工具类
 */
public class DialogTools {

    /**
     * 创建普通单按钮对话框
     *
     * @param ctx      上下文必填
     * @param iconId   图标，如：R.drawable.icon 必填
     * @param title    标题 必填
     * @param message  显示内容 必填
     * @param btnName  按钮名称 必填
     * @param listener 监听器，实现android.content.DialogInterface.OnClickListener接口 必填
     * @return
     */
    public static Dialog createDialog(Context ctx, int iconId, String title, String message, String btnName, android.content.DialogInterface.OnClickListener listener) {
        Dialog dialog = null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctx);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        // 设置对话框的显示内容
        builder.setMessage(message);
        // 添加按钮，android.content.DialogInterface.OnClickListener.OnClickListener
        builder.setPositiveButton(btnName, listener);
        // 创建对话框
        dialog = builder.create();
        
        return dialog;
    }

    /**
     * 创建普通双按钮对话框
     *
     * @param ctx               上下文必填
     * @param iconId            图标，如：R.drawable.icon[不想显示就写0] 必填
     * @param title             标题 必填
     * @param message           显示内容 必填
     * @param btnPositiveName   第一个按钮名称必填
     * @param listener_Positive 第一个监听器，需实现android.content.DialogInterface.OnClickListener接口 必填
     * @param btnNegativeName   第二个按钮名称必填
     * @param listener_Negative 第二个监听器，需实现android.content.DialogInterface.OnClickListener接口 必填
     * @return 对话框实现
     */
    public static Dialog createDialog(Context ctx, int iconId, String title, String message, String btnPositiveName, android.content.DialogInterface.OnClickListener listener_Positive,
                                      String btnNegativeName, android.content.DialogInterface.OnClickListener listener_Negative) {
        Dialog dialog = null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctx);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        // 设置对话框的显示内容
        builder.setMessage(message);
        // 添加按钮，android.content.DialogInterface.OnClickListener.OnClickListener
        builder.setPositiveButton(btnPositiveName, listener_Positive);
        // 添加按钮，android.content.DialogInterface.OnClickListener.OnClickListener
        builder.setNegativeButton(btnNegativeName, listener_Negative);
        // 创建对话框
        dialog = builder.create();
        return dialog;
    }

    /**
     * 创建列表对话框
     *
     * @param ctx      上下文必填
     * @param iconId   图标，如：R.drawable.icon 必填
     * @param title    标题 必填
     * @param itemsId  字符串数组资源id 必填
     * @param listener 监听器，实现android.content.DialogInterface.OnClickListener接口 必填
     * @return
     */
    public static Dialog createListDialog(Context ctx, int iconId, String title, int itemsId, android.content.DialogInterface.OnClickListener listener) {
        Dialog dialog = null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctx);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        // 添加按钮，android.content.DialogInterface.OnClickListener.OnClickListener
        builder.setItems(itemsId, listener);
        // 创建对话框
        dialog = builder.create();
        return dialog;
    }

    /**
     * 创建单选按钮对话框
     *
     * @param ctx       上下文必填
     * @param iconId    图标，如：R.drawable.icon 必填
     * @param title     标题 必填
     * @param itemsId   字符串数组资源id 必填
     * @param listener  单选按钮项监听器，需实现android.content.DialogInterface.OnClickListener接口 必填
     * @param btnName   按钮名称 必填
     * @param listener2 按钮监听器，实现android.content.DialogInterface.OnClickListener接口 必填
     * @return
     */
    public static Dialog createRadioDialog(Context ctx, int iconId, String title, int itemsId, android.content.DialogInterface.OnClickListener listener, String btnName,
                                           android.content.DialogInterface.OnClickListener listener2) {
        Dialog dialog = null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctx);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        // 0: 默认第一个单选按钮被选中
        builder.setSingleChoiceItems(itemsId, 0, listener);
        // 添加确定按钮
        builder.setPositiveButton(btnName, listener2);
        // 创建对话框
        dialog = builder.create();
        return dialog;
    }

    /**
     * 创建单选按钮对话框
     *
     * @param ctx       上下文必填
     * @param iconId    图标，如：R.drawable.icon 必填
     * @param title     标题 必填
     * @param itemsId   字符串数组资源id 必填
     * @param flags     初始复值情况 必填
     * @param listener  单选按钮项监听器，需实现android.content.DialogInterface. OnMultiChoiceClickListener接口 必填
     * @param btnName   按钮名称 必填
     * @param listener2 按钮监听器，实现android.content.DialogInterface.OnClickListener接口 必填
     * @return
     */
    public static Dialog createCheckBoxDialog(Context ctx, int iconId, String title, int itemsId, boolean[] flags, android.content.DialogInterface.OnMultiChoiceClickListener listener, String btnName,
                                              android.content.DialogInterface.OnClickListener listener2) {
        Dialog dialog = null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctx);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        builder.setMultiChoiceItems(itemsId, flags, listener);
        // 添加确定按钮
        builder.setPositiveButton(btnName, listener2);
        // 创建对话框
        dialog = builder.create();
        return dialog;
    }


    private static android.app.ProgressDialog dialog;

    public static ProgressDialog showProgressDialog(Context context, String title, String msg, boolean cancelable) {
        dialog = new ProgressDialog(context);
        // 设置风格为圆形进度条
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        if (title != null && !title.equals(""))
            dialog.setTitle(title);
        // 设置内容
        if (msg != null && !msg.equals(""))
            dialog.setMessage(msg);
        dialog.show();
        // 设置进度条是否可以按返回键取消
        dialog.setCancelable(cancelable);
        return dialog;
    }

    public static ProgressDialog showProgressDialog(Context context, String title, String msg) {
        return showProgressDialog(context, title, msg, true);
    }

    public static ProgressDialog showProgressDialog(Context context, String msg) {
        return showProgressDialog(context, msg, true);
    }

    public static ProgressDialog showProgressDialog(Context context, String msg, boolean cancelable) {
        return showProgressDialog(context, null, msg, true);
    }

    public static ProgressDialog showProgressDialog(Context context) {
        return showProgressDialog(context, true);
    }

    public static ProgressDialog showProgressDialog(Context context, boolean cancelable) {
        return showProgressDialog(context, null, null, true);
    }

    /**
     * 关闭进度条
     */
    public static void closeProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}