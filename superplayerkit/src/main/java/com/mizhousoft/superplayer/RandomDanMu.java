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

    private static SuperPlayerView superPlayerView;

    private static TimerHandler timerHandler;

    private static List<Location> selectableList = new ArrayList<>(Arrays.asList(Location.values()));

    public static void start(SuperPlayerView superPlayerView, String content)
    {
        RandomDanMu.superPlayerView = superPlayerView;

        TextView textView = superPlayerView.findViewById(R.id.superplayer_viewer_text);
        textView.setVisibility(View.VISIBLE);
        textView.setText(content);

        if (null == RandomDanMu.timerHandler)
        {
            RandomDanMu.timerHandler = new TimerHandler();
        }
        RandomDanMu.timerHandler.sendEmptyMessageDelayed(MSG_ID, DELAY_INTERNAL_TIME);
    }

    public static void stop()
    {
        RandomDanMu.timerHandler.removeMessages(MSG_ID);
    }

    private static void randomLocation()
    {
        TextView textView = RandomDanMu.superPlayerView.findViewById(R.id.superplayer_viewer_text);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        if (params instanceof RelativeLayout.LayoutParams)
        {
            Location location = getRandomLocation();

            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) params);
            layoutParams = remakeLayoutParams(location, layoutParams);
            textView.setLayoutParams(layoutParams);
        }
    }

    private static RelativeLayout.LayoutParams remakeLayoutParams(Location location, RelativeLayout.LayoutParams layoutParams)
    {
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.removeRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.removeRule(RelativeLayout.CENTER_VERTICAL);
        layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT);

        if (location.equals(Location.RightBottom))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.setMargins(0, 0, 120, 150);
        }
        else if (location.equals(Location.RightTop))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.setMargins(0, 150, 120, 0);
        }
        else if (location.equals(Location.LeftBottom))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.setMargins(120, 0, 0, 150);
            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        else if (location.equals(Location.LeftTop))
        {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.setMargins(120, 150, 0, 0);
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

    public static Location getRandomLocation()
    {
        if (RandomDanMu.selectableList.isEmpty())
        {
            RandomDanMu.selectableList = new ArrayList<>(Arrays.asList(Location.values()));
        }

        int rnd = new SecureRandom().nextInt(RandomDanMu.selectableList.size());
        Location value = selectableList.remove(rnd);

        return value;
    }

    private static class TimerHandler extends Handler
    {
        @Override
        public void handleMessage(@NonNull Message msg)
        {
            super.handleMessage(msg);

            try
            {
                randomLocation();

                RandomDanMu.timerHandler.sendEmptyMessageDelayed(MSG_ID, DELAY_INTERNAL_TIME);
            }
            catch (Throwable e)
            {
                Log.e("SuperPlayer", "Handle failed.", e);
            }
        }
    }
}