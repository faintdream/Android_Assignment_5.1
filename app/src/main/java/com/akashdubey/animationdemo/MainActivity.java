package com.akashdubey.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1; // declaring objects for Various UI items
    Button btn;
    Animation animAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.tv1);    //binding object to TextView
        btn=(Button)findViewById(R.id.button);    //binding object to button


        btn.setOnClickListener(new View.OnClickListener() {  // calling button onclick event
            @Override
            public void onClick(View v) {
                animAction= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main); //initializing animation class and loading anim

                animAction.setRepeatMode(Animation.RESTART);                    //setting animation attrib
                animAction.setRepeatCount(Animation.INFINITE);                  //setting animation attrib
                tv1.startAnimation(animAction);                                 //binding animation object to startAnimation for tv1
                animAction.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(MainActivity.this,"Animation started",Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this,"Animation ended",Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


    }
}
