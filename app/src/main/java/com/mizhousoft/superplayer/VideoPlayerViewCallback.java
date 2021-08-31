package com.mizhousoft.superplayer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mizhousoft.widget.util.DensityUtils;
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

        ViewGroup.LayoutParams params = textView.getLayoutParams();
        if (params instanceof RelativeLayout.LayoutParams)
        {
            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) params);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.setMargins(0, 0,120, 150);
            textView.setLayoutParams(layoutParams);

//            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) params);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//            layoutParams.setMargins(0, 150,120, 0);
//            textView.setLayoutParams(layoutParams);

//            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) params);
//            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
//            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
//            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
//            layoutParams.setMargins(0, 0,0, 0);
//            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//            textView.setLayoutParams(layoutParams);

//            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) params);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//            layoutParams.setMargins(120, 150,0, 0);
//            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//            textView.setLayoutParams(layoutParams);

//            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) params);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//            layoutParams.setMargins(120, 0,0, 150);
//            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//            textView.setLayoutParams(layoutParams);
        }
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
