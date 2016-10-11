package com.zuolg.fairytaleworld.view;

public interface NumberView {
    /**
     * 加载
     */
    public void onLoad();

    /**
     * 更新
     */
    public void onRefresh();

    /**
     * 更新
     */
    public void onReset();

    /**
     * 提交
     */
    public void onCommit();

    /**
     * 显示错误
     *
     * @param msg
     */
    public void showError(String msg);

    /**
     * 显示进度条
     */
    public void showProgressDialog();

    /**
     * 隐藏进度条
     */
    public void hideProgressDialog();

}