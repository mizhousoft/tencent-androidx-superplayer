package com.mizhousoft.superplayer;

import com.tencent.liteav.demo.superplayer.SuperPlayerView;

public class VideoPlayerViewCallback implements SuperPlayerView.OnSuperPlayerViewCallback
{
    private VideoPlayActivity activity;

    private RandomDanMu randomDanMu = new RandomDanMu();

    public VideoPlayerViewCallback(VideoPlayActivity activity)
    {
        this.activity = activity;
    }

    @Override
    public void onPrepareFullScreenPlay()
    {

    }

    @Override
    public void onStartFullScreenPlay()
    {
        randomDanMu.start(activity.superPlayerView, "1890xxxx3332正在观看视频", true);
    }

    @Override
    public void onStopFullScreenPlay()
    {
        randomDanMu.stop();
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

    }

    @Override
    public void onPlayPause()
    {

    }

    @Override
    public void onPlayResume()
    {

    }

    @Override
    public void onPlayRestart()
    {

    }

    @Override
    public void onPlayEnd()
    {

    }
}
