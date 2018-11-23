package com.example.yulindraadjie.suitmedia1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {


    String name;
    String nameEvent;
    String nameGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        TextView viewName = findViewById(R.id.viewName);
        name = getIntent().getExtras().getString("value");
        viewName.setText(name);

        Button btnEvent = findViewById(R.id.btnEvent);
        nameEvent = getIntent().getExtras().getString("valueEvent");
        btnEvent.setText(nameEvent);

        Button btnGuest = findViewById(R.id.btnGuest);
        nameGuest = getIntent().getExtras().getString("valueGuest");
        btnGuest.setText(nameGuest);

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen2.this,Event.class);
                intent.putExtra("value", name);
                intent.putExtra("valueGuest", nameGuest);
                startActivity(intent);
            }
        });
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen2.this,Guest.class);
                intent.putExtra("value", name);
                intent.putExtra("valueEvent", nameEvent);
                startActivity(intent);
            }
        });
    }
}
