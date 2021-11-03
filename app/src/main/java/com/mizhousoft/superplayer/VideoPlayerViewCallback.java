package com.mizhousoft.superplayer;

import com.mizhousoft.widget.toast.SimplexToast;
import com.tencent.liteav.demo.superplayer.SuperPlayerView;

public class VideoPlayerViewCallback implements SuperPlayerView.OnSuperPlayerViewCallback
{
    private VideoPlayActivity activity;

    public RandomDanMu randomDanMu;

    public VideoPlayerViewCallback(VideoPlayActivity activity)
    {
        this.activity = activity;

        randomDanMu = new RandomDanMu(this.activity.superPlayerView, "1890xxxx3332正在观看视频", false);
    }

    @Override
    public void onPrepareFullScreenPlay()
    {

    }

    @Override
    public void onStartFullScreenPlay()
    {
        randomDanMu.fullscreen(true);
    }

    @Override
    public void onStopFullScreenPlay()
    {
        randomDanMu.fullscreen(false);
    }

    @Override
    public void onClickFloatCloseBtn()
    {

    }

    @Override
    public void onClickSmallReturnBtn()
    {
        activity.finish();
    }

    @Override
    public void onStartFloatWindowPlay()
    {

    }

    @Override
    public void onPlayBegin()
    {
        randomDanMu.setDanMuContent("1390xxxx3332正在观看视频");
        randomDanMu.start();
    }

    @Override
    public void onPlayPause()
    {
        randomDanMu.stop();
    }

    @Override
    public void onPlayResume()
    {
        randomDanMu.start();
    }

    @Override
    public void onPlayRestart()
    {
        randomDanMu.start();
    }

    @Override
    public void onPlayEnd()
    {
        randomDanMu.stop();
    }

    @Override
    public void error(int code, String message)
    {
        if (TXVideoConstants.PLAY_ERR_NET_DISCONNECT_1 == code || TXVideoConstants.PLAY_ERR_NET_DISCONNECT_2 == code)
        {
            SimplexToast.show("网络断连，且经多次重连亦不能恢复，更多重试请自行重启播放。");
        }
        else
        {
            SimplexToast.show(message);
        }
    }
}
