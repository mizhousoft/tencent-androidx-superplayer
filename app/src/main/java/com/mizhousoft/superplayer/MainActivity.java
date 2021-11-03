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
    }

    public void gotoPlayVideo(View view)
    {
        Intent intent = new Intent(this, VideoPlayActivity.class);
        this.startActivity(intent);
    }
}