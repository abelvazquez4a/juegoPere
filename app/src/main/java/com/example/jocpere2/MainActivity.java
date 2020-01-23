package com.example.jocpere2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageView imagenCarmen, imagenRajoy, imagenPablo,imagenCarmen2, imagenRajoy2, imagenPablo2;

    HashMap<Integer,Integer> hashMapImagenes = new HashMap<>();
    ArrayList<Integer> listaImagenes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        hashMapImagenes.put(0,R.drawable.carmen);
        hashMapImagenes.put(1,R.drawable.pablo);
        hashMapImagenes.put(2,R.drawable.rajoy);
        hashMapImagenes.put(3,R.drawable.carmen);
        hashMapImagenes.put(4,R.drawable.pablo);
        hashMapImagenes.put(5,R.drawable.rajoy);

        while (listaImagenes.size()<6){
            int numeroRandom = ((int)(Math.random()*(6)));
            if (!listaImagenes.contains(numeroRandom)){
                listaImagenes.add(numeroRandom);
            }
        }



        imagenCarmen = findViewById(R.id.imageView_carmen);
        imagenCarmen2 = findViewById(R.id.imageView_carmen2);
        imagenPablo = findViewById(R.id.imageView_pablo);
        imagenPablo2 = findViewById(R.id.imageView_pablo2);
        imagenRajoy = findViewById(R.id.imageView_rajoy);
        imagenRajoy2 = findViewById(R.id.imageView_rajoy2);

    }
    public ImageView randomImageView (int numero){
        ImageView image;
        switch (numero){
            case 1: image = findViewById(R.id.imageView_carmen);break;
            case 2: image = findViewById(R.id.imageView_rajoy);break;
            case 3: image = findViewById(R.id.imageView_pablo);break;
            case 4: image = findViewById(R.id.imageView_carmen2);break;
            case 5: image = findViewById(R.id.imageView_rajoy2);break;
            default: image = findViewById(R.id.imageView_pablo2);
        }
        return image;
    }
    public void flipAnimation(View view) {
        final String nombre= getResources().getResourceName(view.getId());
        final ImageView image = findViewById(view.getId());
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(image, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(image, "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                switch (nombre) {
                    case "com.example.jocpere2:id/imageView_carmen" :image.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(0))); break;
                    case "com.example.jocpere2:id/imageView_pablo" : image.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(1)));;break;
                    case "com.example.jocpere2:id/imageView_rajoy" : image.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(2)));;break;
                    case "com.example.jocpere2:id/imageView_carmen2" : image.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(3)));break;
                    case "com.example.jocpere2:id/imageView_pablo2" : image.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(4)));break;
                    case "com.example.jocpere2:id/imageView_rajoy2" : image.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(5)));
                }
                oa2.start();
            }
        });
        oa1.start();
    }
}
