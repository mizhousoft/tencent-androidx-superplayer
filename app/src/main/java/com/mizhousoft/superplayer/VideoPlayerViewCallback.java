package com.mizhousoft.superplayer;

import android.view.View;
import android.widget.TextView;

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
        TextView textView = activity.superPlayerView.findViewById(R.id.superplayer_viewer_text);
        textView.setVisibility(View.VISIBLE);
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
