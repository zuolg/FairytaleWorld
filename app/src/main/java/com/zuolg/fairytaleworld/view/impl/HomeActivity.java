package com.zuolg.fairytaleworld.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.z.andutil.util.T;
import com.zuolg.fairytaleworld.R;
import com.zuolg.fairytaleworld.baiduvoice.BaiduVoiceHelper;
import com.zuolg.fairytaleworld.base.BaseActivity;
import com.zuolg.fairytaleworld.global.AppConst;
import com.zuolg.fairytaleworld.presenter.HomePresenter;
import com.zuolg.fairytaleworld.view.HomeView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 主页
 *
 * @author ZuoLG
 * @time 2016/9/12 14:59
 */
public final class HomeActivity extends BaseActivity implements HomeView, NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    /**
     * presenter对象
     */
    private HomePresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);
        ButterKnife.bind(this);

        presenter = new HomePresenter(this);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击开启百度语音识别
                BaiduVoiceHelper.startBaiduVoiceDialogForResult(HomeActivity.this, AppConst.BAIDU_APIKEY, AppConst.BAIDU_SECRET, AppConst.REQUEST_UI);
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);

        switchToNumber();//默认显示数字页面

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


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        switch (id) {
            case R.id.nav_voice:
                switchToBaiduVoice();
                break;
            case R.id.nav_speech:
                switchToBaiduSpeech();
                break;
            case R.id.nav_poetry:
                switchToPoetry();
                break;
            case R.id.nav_number:
                switchToNumber();
                break;
            case R.id.nav_letter:
                switchToLetter();
                break;
            case R.id.nav_settings:
                switchToSettings();
                break;
            case R.id.nav_share:
                //startActivity(new Intent(HomeActivity.this, ShareActivity.class));
                switchToShare();
                break;
        }

        item.setCheckable(true);//设置选项可选
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchToShare() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ShareActivity()).commit();
        toolbar.setTitle(R.string.nav_share);
    }
    private void switchToSettings() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new SettingsActivity()).commit();
        toolbar.setTitle(R.string.nav_settings);
    }
    private void switchToLetter() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new LetterActivity()).commit();
        toolbar.setTitle(R.string.nav_letter);
    }
    private void switchToNumber() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NumberActivity()).commit();
        toolbar.setTitle(R.string.nav_number);
    }
    private void switchToBaiduVoice() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BaiduVoiceActivity()).commit();
        toolbar.setTitle(R.string.nav_voice);
    }
    private void switchToBaiduSpeech() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BaiduSpeechActivity()).commit();
        toolbar.setTitle(R.string.nav_speech);
    }
    private void switchToPoetry() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new PoetryActivity()).commit();
        toolbar.setTitle(R.string.nav_poetry);
    }


}
