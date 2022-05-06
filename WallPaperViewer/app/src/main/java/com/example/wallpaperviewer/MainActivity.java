package com.example.wallpaperviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    int prev=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytimer= new Timer();
        wpm=WallpaperManager.getInstance(this);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallpaper();
            }
        });
    }
    private void setWallpaper() {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1) {
                    drawable=getResources().getDrawable(R.drawable.img);
                    prev=2;
                } else if(prev==2) {
                    drawable=getResources().getDrawable(R.drawable.img_1);
                    prev=3;
                } else if(prev==3) {
                    drawable=getResources().getDrawable(R.drawable.img_2);
                    prev=4;
                } else if(prev==4) {
                    drawable=getResources().getDrawable(R.drawable.img_3);
                    prev=5;
                } else if(prev==5) {
                    drawable=getResources().getDrawable(R.drawable.img_4);
                    prev=6;
                } else if(prev==6) {
                    drawable=getResources().getDrawable(R.drawable.img_5);
                    prev=1;
                }
                Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        },0,10000);
    }
}