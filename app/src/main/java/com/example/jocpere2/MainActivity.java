package com.example.jocpere2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imagenCarmen, imagenRajoy, imagenPablo,imagenCarmen2, imagenRajoy2, imagenPablo2;
    Animation flipCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenCarmen = findViewById(R.id.imageView_carmen);
        imagenCarmen2 = findViewById(R.id.imageView_carmen2);
        imagenPablo = findViewById(R.id.imageView_pablo);
        imagenPablo2 = findViewById(R.id.imageView_pablo2);
        imagenRajoy = findViewById(R.id.imageView_rajoy);
        imagenRajoy2 = findViewById(R.id.imageView_rajoy2);
        flipCard = AnimationUtils.loadAnimation(this, R.anim.animacioncutre);
    }

    public void flipCard(View view) {
        String nombre= getResources().getResourceName(view.getId());
        Toast.makeText(this, "El id es: "+nombre, Toast.LENGTH_SHORT).show();
        switch (nombre) {
            case "com.example.jocpere2:id/imageView_carmen" :
                imagenCarmen.startAnimation(flipCard);
                imagenCarmen.setBackgroundResource(R.drawable.carmen);
                break;
            case "com.example.jocpere2:id/imageView_pablo" : imagenPablo.startAnimation(flipCard);break;
            case "com.example.jocpere2:id/imageView_rajoy" : imagenRajoy.startAnimation(flipCard);break;
            case "com.example.jocpere2:id/imageView_carmen2" : imagenCarmen2.startAnimation(flipCard);break;
            case "com.example.jocpere2:id/imageView_pablo2" : imagenPablo2.startAnimation(flipCard);break;
            case "com.example.jocpere2:id/imageView_rajoy2" : imagenRajoy2.startAnimation(flipCard);
        }
    }
}
