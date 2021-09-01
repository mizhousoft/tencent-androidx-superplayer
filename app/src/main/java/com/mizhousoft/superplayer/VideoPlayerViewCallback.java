package com.mizhousoft.superplayer;

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
}
