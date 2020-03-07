package com.kh_sof_dev.whatsup_componen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Seplesh_activity extends AppCompatActivity {

    private static final long SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seplesh_activity);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // run() method will be executed when 3 seconds have passed
                //Time to start Intro
                SharedPreferences sp1=getSharedPreferences("Login", MODE_PRIVATE);
                //startActivity(new Intent(LogoAct.this,Intro.class));


                Intent intent = new Intent(Seplesh_activity.this, MainActivity.class);
                startActivity(intent );
                finish();

            }
        }, SPLASH_TIME);

        TextView logo_tv=findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.bounce);
        logo_tv.startAnimation(myanim);
    }
}
