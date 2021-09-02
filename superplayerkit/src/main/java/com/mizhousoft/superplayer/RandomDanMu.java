package com.mizhousoft.superplayer;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.liteav.demo.superplayer.R;
import com.tencent.liteav.demo.superplayer.SuperPlayerView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;

public class RandomDanMu
{
    private static final int MSG_ID = 1200;

    private static final long DELAY_INTERNAL_TIME = 10 * 1000;

    private SuperPlayerView superPlayerView;

    private TimerHandler timerHandler;

    private long internalDelayMs = DELAY_INTERNAL_TIME;

    private boolean isFullScreen;

    private String danMuContent;

    private Location currentLocation = Location.RightBottom;

    private long lastMoveMs = 0;

    private List<Location> selectableList = new ArrayList<>(Arrays.asList(Location.values()));

    public RandomDanMu(SuperPlayerView superPlayerView, String danMuContent, boolean isFullScreen)
    {
        this(superPlayerView, danMuContent, isFullScreen, DELAY_INTERNAL_TIME);
    }

    public RandomDanMu(SuperPlayerView superPlayerView, String danMuContent, boolean isFullScreen, long internalDelayMs)
    {
        this.superPlayerView = superPlayerView;
        this.danMuContent = danMuContent;
        this.isFullScreen = isFullScreen;
        this.internalDelayMs = internalDelayMs;
        this.timerHandler = new TimerHandler();
    }

    public synchronized void start()
    {
        TextView textView = this.superPlayerView.findViewById(R.id.superplayer_random_danmu);
        textView.setVisibility(View.VISIBLE);
        textView.setText(this.danMuContent);

        moveTo(this.currentLocation);

        timerHandler.removeMessages(MSG_ID);
        timerHandler.sendEmptyMessageDelayed(MSG_ID, this.internalDelayMs);
    }

    public synchronized void fullscreen(boolean isFullScreen)
    {
        this.isFullScreen = isFullScreen;

        TextView textView = this.superPlayerView.findViewById(R.id.superplayer_random_danmu);
        textView.setVisibility(View.VISIBLE);
        textView.setText(this.danMuContent);

        moveTo(this.currentLocation);
    }

    public synchronized void stop()
    {
        timerHandler.removeMessages(MSG_ID);
    }

    public void setDanMuContent(String danMuContent)
    {
        this.danMuContent = danMuContent;
    }

    private void moveTo(Location location)
    {
        TextView textView = superPlayerView.findViewById(R.id.superplayer_random_danmu);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        if (params instanceof RelativeLayout.LayoutParams)
        {
            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) params);
            layoutParams = remakeLayoutParams(location, layoutParams);
            textView.setLayoutParams(layoutParams);
        }
    }

    private RelativeLayout.LayoutParams remakeLayoutParams(Location location, RelativeLayout.LayoutParams layoutParams)
    {
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.removeRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.removeRule(RelativeLayout.CENTER_VERTICAL);
        layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT);

        int horizontalOffset = this.isFullScreen ? 120 : 60;
        int verticalOffset = this.isFullScreen ? 150 : 75;

        if (location.equals(Location.RightBottom))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.setMargins(0, 0, horizontalOffset, verticalOffset);
        }
        else if (location.equals(Location.RightTop))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.setMargins(0, verticalOffset, horizontalOffset, 0);
        }
        else if (location.equals(Location.LeftBottom))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.setMargins(horizontalOffset, 0, 0, verticalOffset);
            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        else if (location.equals(Location.LeftTop))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.setMargins(horizontalOffset, verticalOffset, 0, 0);
            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        else
        {
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            layoutParams.setMargins(0, 0, 0, 0);
        }

        return layoutParams;
    }

    private Location getNextLocation()
    {
        if (selectableList.isEmpty())
        {
            selectableList = new ArrayList<>(Arrays.asList(Location.values()));
        }

        int rnd = new SecureRandom().nextInt(selectableList.size());
        Location value = selectableList.remove(rnd);

        return value;
    }

    private class TimerHandler extends Handler
    {
        @Override
        public void handleMessage(@NonNull Message msg)
        {
            super.handleMessage(msg);

            try
            {
                long now = System.currentTimeMillis();
                long offset = now - lastMoveMs;
                if (offset > (internalDelayMs - 2000))
                {
                    currentLocation = getNextLocation();
                    lastMoveMs = now;
                }

                moveTo(currentLocation);

                timerHandler.sendEmptyMessageDelayed(MSG_ID, internalDelayMs);
            }
            catch (Throwable e)
            {
                Log.e("SuperPlayer", "Handle failed.", e);
            }
        }
    }
}