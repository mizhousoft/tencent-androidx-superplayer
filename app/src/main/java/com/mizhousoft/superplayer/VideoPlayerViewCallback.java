package com.mizhousoft.superplayer;

import com.tencent.liteav.demo.superplayer.SuperPlayerView;

public class VideoPlayerViewCallback implements SuperPlayerView.OnSuperPlayerViewCallback
{
    private VideoPlayActivity activity;

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
        RandomDanMu.start(activity.superPlayerView, "1890xxxx3332正在观看视频");
    }

    @Override
    public void onStopFullScreenPlay()
    {
        RandomDanMu.stop();
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
