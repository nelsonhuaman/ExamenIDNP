package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CustomView customView;
    private Button buttonReiniciar;
    private Button buttonGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = findViewById(R.id.customView);
        buttonReiniciar = findViewById(R.id.buttonReiniciar);
        buttonGenerar = findViewById(R.id.buttonGenerar);

        buttonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.reiniciarLados();
            }
        });

        buttonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.incrementarLados();
            }
        });
    }
}