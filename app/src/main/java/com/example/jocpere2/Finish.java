package com.example.jocpere2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Finish extends AppCompatActivity {
    AnimationDrawable gif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        ImageView gifImage = findViewById(R.id.imageView_gif);
        gifImage.setBackgroundResource(R.drawable.gif);
        gif = (AnimationDrawable) gifImage.getBackground();
        gif.start();

    }

    public void playAgain(View view) {
        Intent i = new Intent (this,MainActivity.class);
        startActivity(i);
    }
}
