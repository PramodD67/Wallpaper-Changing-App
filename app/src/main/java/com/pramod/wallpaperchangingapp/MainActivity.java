package com.pramod.wallpaperchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int images[] = new int[]{
            R.drawable.yuva,
            R.drawable.wp5747239_full_screen_sai_baba_hd_computer_desktop_wallpapers,
            R.drawable.kgf
    };

    Button btn;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

btn = findViewById(R.id.change_btn);

 btn.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {

         new Timer().schedule(new changewallpaper(), 0 , 3000); {

         };
     }
 });


            }

            class changewallpaper extends TimerTask{

        WallpaperManager wall = WallpaperManager.getInstance(getBaseContext());
        @Override
        public void run() {
            try {
                wall.setBitmap(BitmapFactory.decodeResource(getResources(), images[i]));
                i++;

                if(i==3){
                    i=0;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



        }
