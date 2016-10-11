package com.zuolg.fairytaleworld.baiduspeech;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.z.andutil.util.L;
import com.z.andutil.util.SDCardUtils;
import com.zuolg.fairytaleworld.baiduspeech.global.AppConst;

import java.util.List;

/**
 * 语音合成工具类
 *
 * @author ZuoLG
 * @time 2016/9/12 16:04
 */
public class BaiduSpeechUtil implements SpeechSynthesizerListener {

    private String mSampleDirPath;

    private SpeechSynthesizer speechSynthesizer;
    private Context context;
    private String apiKey;
    private String secret;
    private String appID;

    public BaiduSpeechUtil(Context activity, String apiKey, String secret, String appID) {
        this.context = activity;
        this.apiKey = apiKey;
        this.secret = secret;
        this.appID = appID;
        new Thread(new Runnable() {
            @Override
            public void run() {
                L.d("开启启动语音合成！");
                getDir();
                init();
                L.d("启动语音合成成功");
            }
        }).start();
    }

    private void getDir() {
        if (mSampleDirPath == null) {
            String sdcardPath = SDCardUtils.getSDCardPath() + AppConst.ROOT_DIR_NAME;
            mSampleDirPath = sdcardPath + "/" + AppConst.SAMPLE_DIR_NAME;
        }
        L.d("mSampleDirPath=="+mSampleDirPath);
    }

    /**
     * 初始化合成相关组件
     *
     * @author JPH
     * @date 2015-4-14 下午1:36:53
     */
    private void init() {
        this.speechSynthesizer = SpeechSynthesizer.getInstance();
        this.speechSynthesizer.setContext(context);
        this.speechSynthesizer.setSpeechSynthesizerListener(this);
        // 文本模型文件路径 (离线引擎使用)
        this.speechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, mSampleDirPath + "/"
                + AppConst.TEXT_MODEL_NAME);
        // 声学模型文件路径 (离线引擎使用)
        this.speechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, mSampleDirPath + "/"
                + AppConst.SPEECH_FEMALE_MODEL_NAME);
        // 本地授权文件路径,如未设置将使用默认路径.设置临时授权文件路径，LICENCE_FILE_NAME请替换成临时授权文件的实际路径，仅在使用临时license文件时需要进行设置，如果在[应用管理]中开通了正式离线授权，不需要设置该参数，建议将该行代码删除（离线引擎）
        // 如果合成结果出现临时授权文件将要到期的提示，说明使用了临时授权文件，请删除临时授权即可。
        this.speechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_LICENCE_FILE, mSampleDirPath + "/"
                + AppConst.LICENSE_FILE_NAME);
        // 请替换为语音开发者平台上注册应用得到的App ID (离线授权)
        this.speechSynthesizer.setAppId(this.appID);
        // 请替换为语音开发者平台注册应用得到的apikey和secretkey (在线授权)
        this.speechSynthesizer.setApiKey(this.apiKey, this.secret);
        // 发音人（在线引擎），可用参数为0,1,2,3。。。（服务器端会动态增加，各值含义参考文档，以文档说明为准。0--普通女声，1--普通男声，2--特别男声，3--情感男声。。。）
        this.speechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0");
        // 设置Mix模式的合成策略
        this.speechSynthesizer.setParam(SpeechSynthesizer.PARAM_MIX_MODE, SpeechSynthesizer.MIX_MODE_DEFAULT);
        // 授权检测接口(只是通过AuthInfo进行检验授权是否成功。)
        // AuthInfo接口用于测试开发者是否成功申请了在线或者离线授权，如果测试授权成功了，可以删除AuthInfo部分的代码（该接口首次验证时比较耗时），不会影响正常使用（合成使用时SDK内部会自动验证授权）
        AuthInfo authInfo = this.speechSynthesizer.auth(TtsMode.MIX);

        if (authInfo.isSuccess()) {
            L.d("auth success");
        } else {
            String errorMsg = authInfo.getTtsError().getDetailMessage();
            L.d("auth failed errorMsg=" + errorMsg);
        }

        // 初始化tts
        speechSynthesizer.initTts(TtsMode.MIX);
        // 加载离线英文资源（提供离线英文合成功能）
        int result = speechSynthesizer.loadEnglishModel(mSampleDirPath + "/" + AppConst.ENGLISH_TEXT_MODEL_NAME, mSampleDirPath
                        + "/" + AppConst.ENGLISH_SPEECH_FEMALE_MODEL_NAME);
        L.d("loadEnglishModel result=" + result);

    }

    /**
     * 开始文本合成并朗读
     *
     * @author ZuoLG
     * @time 2016/9/12 16:09
     */
    public void speak(final String content) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int ret = speechSynthesizer.speak(content.toString());
                L.d("合成结果："+ret);
                if (ret != 0) {
                    Log.e("inf", "开始合成器失败：" + ret);
                }
            }
        }).start();
    }

    /**
     * 批量合成并播放文本文件，一次可传入一个list，这个list会按顺序合成播放。
     *
     * @author ZuoLG
     * @time 2016/9/12 16:30
     */
    public void batchSpeak(final List<SpeechSynthesizeBag> speechSynthesizeBags) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int ret = speechSynthesizer.batchSpeak(speechSynthesizeBags);
                if (ret != 0) {
                    Log.e("inf", "开始合成器失败：" + ret);
                }
            }
        }).start();
    }

    /**
     * 取消本次合成并停止朗读
     *
     * @author ZuoLG
     * @time 2016/9/12 16:09
     */
    public void cancle() {
        speechSynthesizer.stop();
    }

    /**
     * 暂停文本朗读，如果没有调用speak(String)方法或者合成器初始化失败，该方法将无任何效果
     *
     * @author ZuoLG
     * @time 2016/9/12 16:09
     */
    public void pause() {
        speechSynthesizer.pause();
    }

    /**
     * 继续文本朗读，如果没有调用speak(String)方法或者合成器初始化失败，该方法将无任何效果
     *
     * @author ZuoLG
     * @time 2016/9/12 16:09
     */
    public void resume() {
        speechSynthesizer.resume();
    }

    /**
     * 为语音合成器设置相关参数
     *
     * @author JPH
     * @date 2015-4-14 下午1:45:11
     */
    private void setParams() {
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0");//发音人，目前支持女声(0)和男声(1)
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_VOLUME, "9");//音量，取值范围[0, 9]，数值越大，音量越大
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEED, "5");//朗读语速，取值范围[0, 9]，数值越大，语速越快
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_PITCH, "9");//音调，取值范围[0, 9]，数值越大，音量越高
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_AUDIO_ENCODE,
                SpeechSynthesizer.AUDIO_ENCODE_AMR);//音频格式，支持bv/amr/opus/mp3，取值详见随后常量声明
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_AUDIO_RATE,
                SpeechSynthesizer.AUDIO_BITRATE_AMR_15K85);//音频比特率，各音频格式支持的比特率详见随后常量声明
    }


    //合成开始时的回调方法。
    @Override
    public void onSynthesizeStart(String s) {

    }

    //当获取合成数据时调用的方法，合成数据会分多次返回，需自行保存。
    @Override
    public void onSynthesizeDataArrived(String s, byte[] bytes, int i) {

    }

    //当合成完成时调用的方法。
    @Override
    public void onSynthesizeFinish(String s) {

    }

    //当开始播放时调用的方法。
    @Override
    public void onSpeechStart(String s) {
        Log.i("msg", "朗读开始");
    }

    //当进度进度改变时调用的方法。
    @Override
    public void onSpeechProgressChanged(String s, int i) {
        L.d("当进度进度改变时调用的方法");

    }

    //播放完成时调用的方法。
    @Override
    public void onSpeechFinish(String s) {
        L.d("播放完成时调用的方法。");
    }

    //出错时的回调函数。
    @Override
    public void onError(String s, SpeechError speechError) {
        L.d("出错时的回调函数。");
    }
}
