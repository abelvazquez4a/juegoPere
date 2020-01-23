package com.example.jocpere2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
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
    int idImagen1=0,idImagen2=0,idImagenDrawable1=0,idImagenDrawable2=0;
    Handler handler = new Handler();

    HashMap<Integer,Integer> hashMapImagenes = new HashMap<>();
    ArrayList<Integer> listaImagenes = new ArrayList<>();
    ArrayList<Integer> comprobacion = new ArrayList<>();
    HashMap<Integer, Integer> hashMapDeIdImagen = new HashMap<>();
    HashMap<Integer, Integer> hashMapDeIdDrawable = new HashMap<>();
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


    public void move(View view, int idImagen){
        if(comprobacion.size()<1){
            hashMapDeIdDrawable.put(0,idImagen);
            hashMapDeIdImagen.put(0,view.getId());
            comprobacion.add(1);
        }
        else{
            hashMapDeIdDrawable.put(1,idImagen);
            hashMapDeIdImagen.put(1,view.getId());
            Log.d("pruebaLol","idImagen1: "+hashMapDeIdImagen.get(0));
            Log.d("pruebaLol","idImagen2: "+hashMapDeIdImagen.get(1));
            Log.d("pruebaLol","idDrawable1: "+hashMapDeIdDrawable.get(0));
            Log.d("pruebaLol","idDrawable2: "+hashMapDeIdDrawable.get(1));
            int integerImagen1Id = hashMapDeIdDrawable.get(0);
            int integerImagen2Id = hashMapDeIdDrawable.get(1);
            if (integerImagen1Id!=integerImagen2Id){
                Log.d("pruebaLol","Entro donde no tengo que entrar");
                flipAnimationBack(findViewById(hashMapDeIdImagen.get(0)));
                flipAnimationBack(findViewById(hashMapDeIdImagen.get(1)));
            }
            hashMapDeIdImagen.clear();
            hashMapDeIdDrawable.clear();
            comprobacion.clear();
        }
    }

    public void comprobarIguals(){
        if (!(hashMapDeIdDrawable.get(0)==hashMapDeIdDrawable.get(1))){
            flipAnimationBack(findViewById(hashMapDeIdImagen.get(0)));
            flipAnimationBack(findViewById(hashMapDeIdImagen.get(1)));
        }
    }
    public void flipAnimationBack(View view){
        view.setBackgroundResource(R.drawable.carta);
    }

    public void flipAnimation(final View view) {
        int idImagen;
        final String nombre= getResources().getResourceName(view.getId());
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                switch (nombre) {

                    case "com.example.jocpere2:id/imageView_carmen" :
                        view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(0)));
                        move(view,hashMapImagenes.get(listaImagenes.get(0)));
                        break;
                    case "com.example.jocpere2:id/imageView_pablo" :
                        view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(1)));
                        move(view,hashMapImagenes.get(listaImagenes.get(1)));
                        ;break;
                    case "com.example.jocpere2:id/imageView_rajoy" :
                        view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(2)));
                        move(view,hashMapImagenes.get(listaImagenes.get(2)));
                        ;break;
                    case "com.example.jocpere2:id/imageView_carmen2" :
                        view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(3)));
                        move(view,hashMapImagenes.get(listaImagenes.get(3)));
                        ;break;
                    case "com.example.jocpere2:id/imageView_pablo2" :
                        view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(4)));
                        move(view,hashMapImagenes.get(listaImagenes.get(4)));
                        ;break;

                    case "com.example.jocpere2:id/imageView_rajoy2" :
                        view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(5)));
                        move(view,hashMapImagenes.get(listaImagenes.get(5)));
                }
                oa2.start();
            }
        });
        oa1.start();
/*
        switch (nombre) {
            case "com.example.jocpere2:id/imageView_carmen" :
                idImagen=hashMapImagenes.get(listaImagenes.get(0));
                break;
            case "com.example.jocpere2:id/imageView_pablo" :
                idImagen=hashMapImagenes.get(listaImagenes.get(1));
                ;break;
            case "com.example.jocpere2:id/imageView_rajoy" :
                idImagen=hashMapImagenes.get(listaImagenes.get(2));
                ;break;
            case "com.example.jocpere2:id/imageView_carmen2" :
                idImagen=hashMapImagenes.get(listaImagenes.get(3));
                ;break;
            case "com.example.jocpere2:id/imageView_pablo2" :
                idImagen=hashMapImagenes.get(listaImagenes.get(4));
                ;break;
            default :
                idImagen=hashMapImagenes.get(listaImagenes.get(5));
        }*/
        ;
    }
}
