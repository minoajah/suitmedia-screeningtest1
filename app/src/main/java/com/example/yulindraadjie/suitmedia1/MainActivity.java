package com.example.yulindraadjie.suitmedia1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String name;
    String nameEvent="Pilih event";
    String nameGuest="Pilih guest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtName = findViewById(R.id.txtName);
        final Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Screen2.class);
                name = txtName.getText().toString();
                intent.putExtra("value",name);
                intent.putExtra("valueEvent",nameEvent);
                intent.putExtra("valueGuest",nameGuest);
                startActivity(intent);
            }
        });

    }
}
