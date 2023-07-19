package com.mizhousoft.superplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mizhousoft.widget.toast.SimplexToast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimplexToast.init(this);

        String licenceURL = "https://license.vod2.myqcloud.com/license/v2/1255592235_1/v_cube.license";
        String licenceKey = "48593f0825fbb36cea2a9da1ac1e4341";
        SuperPlayerLicense.setLicence(licenceURL, licenceKey, this);
    }

    public void gotoPlayVideo(View view)
    {
        Intent intent = new Intent(this, VideoPlayActivity.class);
        this.startActivity(intent);
    }
}