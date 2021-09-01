package com.mizhousoft.superplayer;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.mizhousoft.widget.util.StatusBarUtils;
import com.tencent.liteav.demo.superplayer.SuperPlayerDef;
import com.tencent.liteav.demo.superplayer.SuperPlayerModel;
import com.tencent.liteav.demo.superplayer.SuperPlayerView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayActivity extends AppCompatActivity
{
    public SuperPlayerView superPlayerView;

    private RandomDanMu randomDanMu = new RandomDanMu();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        final Window window = getWindow();
        //取消设置Window半透明的Flag
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ////添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏为透明
        window.setStatusBarColor(getResources().getColor(R.color.black));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        StatusBarUtils.setStatusBarDarkMode(this);

        superPlayerView = findViewById(R.id.pv_super_player);
        superPlayerView.setPlayerViewCallback(new VideoPlayerViewCallback(this));

        SuperPlayerModel model = new SuperPlayerModel();
        model.title = "测试视频";
        model.url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        superPlayerView.playWithModel(model);

        randomDanMu.start(this.superPlayerView, "1890xxxx3332正在观看视频", false);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // 重新开始播放
        if (superPlayerView.getPlayerState() == SuperPlayerDef.PlayerState.PAUSE)
        {
            superPlayerView.onResume();
            if (superPlayerView.getPlayerMode() == SuperPlayerDef.PlayerMode.FLOAT)
            {
                superPlayerView.switchPlayMode(SuperPlayerDef.PlayerMode.WINDOW);
            }
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        // 停止播放
        if (superPlayerView.getPlayerMode() != SuperPlayerDef.PlayerMode.FLOAT)
        {
            if (superPlayerView.getPlayerState() == SuperPlayerDef.PlayerState.PLAYING
                    || superPlayerView.getPlayerState() == SuperPlayerDef.PlayerState.LOADING)
            {
                superPlayerView.onPause();
            }
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        randomDanMu.stop();
        superPlayerView.release();
        if (superPlayerView.getPlayerMode() != SuperPlayerDef.PlayerMode.FLOAT)
        {
            superPlayerView.resetPlayer();
        }
    }
}