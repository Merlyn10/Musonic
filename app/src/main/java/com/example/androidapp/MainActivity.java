package com.example.androidapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    LottieAnimationView laView;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },6000);
    }
}