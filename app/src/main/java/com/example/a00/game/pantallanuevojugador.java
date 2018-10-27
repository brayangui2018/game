package com.example.a00.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pantallanuevojugador extends AppCompatActivity {
    private Button guardarnick;
    private EditText nombres;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallanuevojugador);
        guardarnick=findViewById(R.id.idguardarnick);
        nombres=findViewById(R.id.nombrejugador);


        guardarnick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nom=nombres.getText().toString();

                Intent i = new Intent();
                i.putExtra("nombrepersona",nom);

                setResult(RESULT_OK,i);
                finish();

            }
        });



    }
}
