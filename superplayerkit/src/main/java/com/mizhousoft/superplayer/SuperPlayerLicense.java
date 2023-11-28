package com.mizhousoft.superplayer;

import android.content.Context;
import android.util.Log;

import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveBaseListener;

public class SuperPlayerLicense
{
    public static void setLicence(String licenceURL, String licenceKey, Context context)
    {
        TXLiveBase.getInstance().setLicence(context, licenceURL, licenceKey);

        TXLiveBase.setListener(new TXLiveBaseListener()
        {
            @Override
            public void onLicenceLoaded(int result, String reason)
            {
                Log.i("SuperPlayer", "onLicenceLoaded: result:" + result + ", reason:" + reason);
            }
        });
    }
}
