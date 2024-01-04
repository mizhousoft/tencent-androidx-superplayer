package com.usmartcloud.repair.develop;

import android.util.Log;

import com.mizhousoft.superplayer.TXVideoConstants;
import com.mizhousoft.widget.toast.SimplexToast;
import com.tencent.liteav.demo.superplayer.SuperPlayerView;

public class VideoPlayerViewCallback implements SuperPlayerView.OnSuperPlayerViewCallback
{
    private VideoPlayActivity activity;

    public VideoPlayerViewCallback(VideoPlayActivity activity)
    {
        this.activity = activity;
    }

    @Override
    public void onStartFullScreenPlay()
    {

    }

    @Override
    public void onStopFullScreenPlay()
    {

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
    public void onPlaying()
    {
        Log.i("TXVod", String.valueOf("onPlaying"));
    }

    @Override
    public void onPlayPause()
    {
        Log.i("TXVod", String.valueOf("onPlayPause"));
    }

    @Override
    public void onPlayEnd()
    {
        Log.i("TXVod", String.valueOf("onPlayEnd"));
    }

    @Override
    public void onPlayProgress(long current, long duration, long playable)
    {
        Log.i("TXVod", String.valueOf("onPlayProgress ") + current + " " + duration + " " + playable);
    }

    @Override
    public void onError(int code)
    {
        if (TXVideoConstants.PLAY_ERR_NET_DISCONNECT_1 == code || TXVideoConstants.PLAY_ERR_NET_DISCONNECT_2 == code)
        {
            SimplexToast.show("网络断连，且经多次重连亦不能恢复，更多重试请自行重启播放。");
        }
        else
        {
            SimplexToast.show("视频无法播放");
        }
    }

    @Override
    public void onShowCacheListClick()
    {

    }
}
