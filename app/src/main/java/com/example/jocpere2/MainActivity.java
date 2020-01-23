package com.example.jocpere2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageView imagenCarmen, imagenRajoy, imagenPablo,imagenCarmen2, imagenRajoy2, imagenPablo2;
    HashMap<String,Integer> hashMapIdImagenes = new HashMap<>();
    HashMap<String,String> hashMapNombreImagenes = new HashMap<>();
    HashMap<Integer,Integer> hashMapImagenes = new HashMap<>();
    ArrayList<Integer> listaImagenes = new ArrayList<>();
    ArrayList<Integer> contenedorDeId = new ArrayList<>();
    ArrayList<Integer> contadorJugadas = new ArrayList<>();

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
        contenedorDeId.add(imagenCarmen.getId());
        contenedorDeId.add(imagenCarmen2.getId());
        contenedorDeId.add(imagenPablo.getId());
        contenedorDeId.add(imagenPablo2.getId());
        contenedorDeId.add(imagenRajoy.getId());
        contenedorDeId.add(imagenRajoy2.getId());
        hashMapImagenes.put(0,R.drawable.carmen);
        hashMapImagenes.put(1,R.drawable.pablo);
        hashMapImagenes.put(2,R.drawable.rajoy);
        hashMapImagenes.put(3,R.drawable.carmen);
        hashMapImagenes.put(4,R.drawable.pablo);
        hashMapImagenes.put(5,R.drawable.rajoy);
        inicializarArrayList(listaImagenes);
        generarImagenesAleatorias(contenedorDeId);
    }

    public void jugada (final View view){

        Log.d("prueba","size contador: "+contadorJugadas.size());
        if (contadorJugadas.isEmpty()){
            Log.d("prueba","entroEmpty");
            levantarCarta(view);
            contadorJugadas.add(view.getId());
        }
        else if (contadorJugadas.size()==1){
            Log.d("prueba","entroNoEmpty");
            new CountDownTimer(1000, 1000) {
                public void onFinish() {
                    contadorJugadas.add(view.getId());
                    comprobarJugada(contadorJugadas);
                    contadorJugadas.clear();
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }

                public void onTick(long millisUntilFinished) {
                    levantarCarta(view);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }
            }.start();
        }
    }
    public void comprobarJugada(ArrayList<Integer>jugadasAComparar)  {
        ImageView imageView1 = findViewById(jugadasAComparar.get(0));
        ImageView imageView2 = findViewById(jugadasAComparar.get(1));
        String nombreImageView = imageView1.getResources().getResourceName(imageView1.getId());
        String nombreImageView2 = imageView2.getResources().getResourceName(imageView2.getId());
        nombreImageView=arreglarNombre(nombreImageView);
        nombreImageView2=arreglarNombre(nombreImageView2);
        String nombreDrawable1 = hashMapNombreImagenes.get(nombreImageView);
        String nombreDrawable2 = hashMapNombreImagenes.get(nombreImageView2);
        Log.d("prueba","drawable1: "+nombreDrawable1);
        Log.d("prueba","drawable2: "+nombreDrawable2);
        if (nombreDrawable1==nombreDrawable2){
            imageView1 = findViewById(hashMapIdImagenes.get(nombreImageView));
            imageView2 = findViewById(hashMapIdImagenes.get(nombreImageView2));
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }
        else {
            imageView1 = findViewById(hashMapIdImagenes.get(nombreImageView));
            imageView2 = findViewById(hashMapIdImagenes.get(nombreImageView2));
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView1 = findViewById(jugadasAComparar.get(0));
            imageView2 = findViewById(jugadasAComparar.get(1));
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            final View v1=imageView1;
            final View v2=imageView2;
            girarConAnimacion(v1);
            girarConAnimacion(v2);
        }
    }
    public void generarImagenesAleatorias(ArrayList<Integer>lista){
        for (int id : lista ){
            asignarImagenAleatoria(findViewById(id));
        }
    }
    public void asignarImagenAleatoria (View view){
        String nombre = view.getResources().getResourceName(view.getId());
        switch (nombre) {
            case "com.example.jocpere2:id/imageView_carmen" :
                view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(0)));
                view.setVisibility(View.INVISIBLE);
                hashMapIdImagenes.put("com.example.jocpere2:id/imageView_carmen",view.getId());
                hashMapNombreImagenes.put("com.example.jocpere2:id/imageView_carmen",dameElNombreDelIndice(listaImagenes.get(0)));
                break;
            case "com.example.jocpere2:id/imageView_pablo" :
                view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(1)));
                view.setVisibility(View.INVISIBLE);
                hashMapIdImagenes.put("com.example.jocpere2:id/imageView_pablo",view.getId());
                hashMapNombreImagenes.put("com.example.jocpere2:id/imageView_pablo",dameElNombreDelIndice(listaImagenes.get(1)));
                ;break;
            case "com.example.jocpere2:id/imageView_rajoy" :
                view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(2)));
                view.setVisibility(View.INVISIBLE);
                hashMapIdImagenes.put("com.example.jocpere2:id/imageView_rajoy",view.getId());
                hashMapNombreImagenes.put("com.example.jocpere2:id/imageView_rajoy",dameElNombreDelIndice(listaImagenes.get(2)));
                ;break;
            case "com.example.jocpere2:id/imageView_carmen2" :
                view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(3)));
                view.setVisibility(View.INVISIBLE);
                hashMapIdImagenes.put("com.example.jocpere2:id/imageView_carmen2",view.getId());
                hashMapNombreImagenes.put("com.example.jocpere2:id/imageView_carmen2",dameElNombreDelIndice(listaImagenes.get(3)));
                ;break;
            case "com.example.jocpere2:id/imageView_pablo2" :
                view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(4)));
                view.setVisibility(View.INVISIBLE);
                hashMapIdImagenes.put("com.example.jocpere2:id/imageView_pablo2",view.getId());
                hashMapNombreImagenes.put("com.example.jocpere2:id/imageView_pablo2",dameElNombreDelIndice(listaImagenes.get(4)));
                ;break;

            case "com.example.jocpere2:id/imageView_rajoy2" :
                view.setBackgroundResource(hashMapImagenes.get(listaImagenes.get(5)));
                view.setVisibility(View.INVISIBLE);
                hashMapIdImagenes.put("com.example.jocpere2:id/imageView_rajoy2",view.getId());
                hashMapNombreImagenes.put("com.example.jocpere2:id/imageView_rajoy2",dameElNombreDelIndice(listaImagenes.get(5)));
        }
    }
    public void levantarCarta (View view){
        String nombre = view.getResources().getResourceName(view.getId());
        String nombreBueno=arreglarNombre(nombre);
        view.setVisibility(View.INVISIBLE);
       if (!nombreBueno.isEmpty()) view = findViewById(hashMapIdImagenes.get(nombreBueno));
        final View v = view;
        v.setVisibility(View.VISIBLE);
        girarConAnimacion(v);
    }
    public String arreglarNombre (String nombre){
        String copiaNombre=nombre;
        String nombreBueno="";
        if (nombre.charAt(nombre.length()-1)=='B'){
            nombreBueno=nombre.substring(0,nombre.length()-1);
        }
        if (nombreBueno.isEmpty()) nombreBueno=copiaNombre;
        return nombreBueno;
    }
    public String dameElNombreDelIndice(int indice){
        String nombre="";
        switch (indice){
            case 0 : nombre="carmen";break;
            case 1 : nombre="pablo";break;
            case 2 : nombre="rajoy";break;
            case 3 : nombre="carmen";break;
            case 4 : nombre="pablo";break;
            case 5 : nombre="rajoy";break;
        }
        return nombre;
    }
    public void girarConAnimacion (final View view){
        view.animate().withLayer()
                .rotationY(90)
                .setDuration(300)
                .withEndAction(
                        new Runnable() {
                            @Override public void run() {
                                // second quarter turn
                                view.setRotationY(-90);
                                view.animate().withLayer()
                                        .rotationY(0)
                                        .setDuration(300)
                                        .start();
                            }
                        }
                ).start();
    }
    public void inicializarArrayList(ArrayList<Integer>listaImagenes){
        while (listaImagenes.size()<6){
            int numeroRandom = ((int)(Math.random()*(6)));
            if (!listaImagenes.contains(numeroRandom)){
                listaImagenes.add(numeroRandom);
            }
        }
    }
}
