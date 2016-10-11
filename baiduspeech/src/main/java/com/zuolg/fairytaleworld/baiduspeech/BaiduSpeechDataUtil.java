package com.zuolg.fairytaleworld.baiduspeech;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.z.andutil.util.L;
import com.z.andutil.util.SDCardUtils;
import com.z.andutil.util.ZipUtil;
import com.zuolg.fairytaleworld.baiduspeech.global.AppConst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 百度语音初始化数据文件助手
 *
 * @author ZuoLG
 * @time 2016/9/12 17:07
 */
public class BaiduSpeechDataUtil {

    private Context context;

    private String apiKey;
    private String secret;
    private String appID;

    private String mSampleDirPath;

    public BaiduSpeechDataUtil(Context activity, String apiKey, String secret, String appID) {
        this.context = activity;
        this.apiKey = apiKey;
        this.secret = secret;
        this.appID = appID;

        new Thread(new Runnable() {
            @Override
            public void run() {
                init();
                L.d("资源初始化成功！");
            }
        }).start();


    }

    /**
     * 初始化合成相关组件
     *
     * @author JPH
     * @date 2015-4-14 下午1:36:53
     */
    private void init() {
        if (!SDCardUtils.isSDCardEnable()) {
            L.d("sd卡异常！");
            return;
        }
        if (mSampleDirPath == null) {
            String sdcardPath = SDCardUtils.getSDCardPath() + AppConst.ROOT_DIR_NAME;
            mSampleDirPath = sdcardPath + "/" + AppConst.SAMPLE_DIR_NAME;
        }
        //判断目录是否存在
        makeDir(mSampleDirPath);
        copyFromAssetsToSdcard(false, AppConst.SPEECH_FEMALE_MODEL_NAME, mSampleDirPath + "/" + AppConst.SPEECH_FEMALE_MODEL_NAME);
        copyFromAssetsToSdcard(false, AppConst.SPEECH_MALE_MODEL_NAME, mSampleDirPath + "/" + AppConst.SPEECH_MALE_MODEL_NAME);
        copyFromAssetsToSdcard(false, AppConst.TEXT_MODEL_NAME, mSampleDirPath + "/" + AppConst.TEXT_MODEL_NAME);
        copyFromAssetsToSdcard(false, AppConst.LICENSE_FILE_NAME, mSampleDirPath + "/" + AppConst.LICENSE_FILE_NAME);
        copyFromAssetsToSdcard(false, "english/" + AppConst.ENGLISH_SPEECH_FEMALE_MODEL_NAME, mSampleDirPath + "/"
                + AppConst.ENGLISH_SPEECH_FEMALE_MODEL_NAME);
        copyFromAssetsToSdcard(false, "english/" + AppConst.ENGLISH_SPEECH_MALE_MODEL_NAME, mSampleDirPath + "/"
                + AppConst.ENGLISH_SPEECH_MALE_MODEL_NAME);
        copyFromAssetsToSdcard(false, "english/" + AppConst.ENGLISH_TEXT_MODEL_NAME, mSampleDirPath + "/"
                + AppConst.ENGLISH_TEXT_MODEL_NAME);

    }

    private void makeDir(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    /**
     * 将sample工程需要的资源文件拷贝到SD卡中使用（授权文件为临时授权文件，请注册正式授权）
     *
     * @param isCover 是否覆盖已存在的目标文件
     * @param source
     * @param dest
     */
    private void copyFromAssetsToSdcard(boolean isCover, String source, String dest) {
        File file = new File(dest);
        if (isCover || (!isCover && !file.exists())) {
            InputStream is = null;
            FileOutputStream fos = null;
            try {
                is = context.getResources().getAssets().open(source);
                String path = dest;
                fos = new FileOutputStream(path);
                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = is.read(buffer, 0, 1024)) >= 0) {
                    fos.write(buffer, 0, size);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
