package com.example.a00.game;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnnuevo,btnjugar,btnpuntajes;
    private static final int ID=1;
    private static final int ID2=2;

    private String nomb,puntajesjugador;


    private ArrayList<String> nombreseleccionado=new ArrayList<String>();
    private ArrayList<String> mayorespuntajes=new ArrayList<String>();
    private ArrayList<String> puntajes=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnuevo=findViewById(R.id.nuevo);
        btnjugar=findViewById(R.id.partida);
        btnpuntajes=findViewById(R.id.puntajes);

        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),pantallanuevojugador.class);
                startActivityForResult(i,ID);
            }
});

        btnjugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),pantallajugar.class);
                i.putExtra("nombrejugador",nomb);
                startActivityForResult(i,ID2);
            }
        });

    }

    public void pantallapuntaje(View v){


        Intent i=new Intent(this,pantallapuntajes.class);
        i.putStringArrayListExtra("nombresjugador",nombreseleccionado);
        i.putStringArrayListExtra("puntajesjugador",puntajes);
        startActivity(i);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK && requestCode==ID){
            nomb = data.getStringExtra("nombrepersona");

            nombreseleccionado.add(nomb);

            Toast.makeText(this, "nombre jugador : " + nomb, Toast.LENGTH_LONG).show();

        }

        if(resultCode==RESULT_OK && requestCode==ID2){
            puntajesjugador = data.getStringExtra("puntajepersona");

           /* int size=puntajes.size();
            for(int x=0;x<puntajes.size();x++) {
                String numeros=(puntajes.get(x));
                int numerosmayores= Integer.parseInt(numeros);

            }*/


            puntajes.add(puntajesjugador);

            Toast.makeText(this, "puntaje de "+nomb+" es : "+puntajesjugador, Toast.LENGTH_LONG).show();

        }

    }

}
