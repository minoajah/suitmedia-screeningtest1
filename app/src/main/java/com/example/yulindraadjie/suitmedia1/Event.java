package com.example.yulindraadjie.suitmedia1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Event extends AppCompatActivity {
    String event;

    String name;
    String guestName;
    String nameEvent[] = {"Synchronize Fest", "Car Free Day", "Binus Run", "Charity For Palu"};
    String dateEvent[] = {"5 Oktober 2018", "28 Oktober 2018", "4 November 2018", "11 November 2018"};
    int images[] = {R.drawable.image1,R.drawable.image2,R.drawable.image3, R.drawable.image4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        name = getIntent().getExtras().getString("value");
        guestName = getIntent().getExtras().getString("valueGuest");

        ListView listEvent = findViewById(R.id.listEvent);
        EventAdapter adapter = new EventAdapter(this, nameEvent, dateEvent, images);
        listEvent.setAdapter(adapter);
        listEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Toast.makeText(Event.this, "Synchronize", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Event.this,Screen2.class);
                    intent.putExtra("valueEvent",nameEvent[0]);
                    intent.putExtra("value", name);
                    intent.putExtra("valueGuest", guestName);
                    startActivity(intent);
                }
                else if(position == 1) {
                    Toast.makeText(Event.this, "Car Free Day", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Event.this, Screen2.class);
                    intent1.putExtra("valueEvent", nameEvent[1]);
                    intent1.putExtra("value", name);
                    intent1.putExtra("valueGuest", guestName);
                    startActivity(intent1);
                }else if(position == 2) {
                    Toast.makeText(Event.this, "Binus Run", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(Event.this, Screen2.class);
                    intent2.putExtra("valueEvent", nameEvent[2]);
                    intent2.putExtra("value", name);
                    intent2.putExtra("valueGuest", guestName);
                    startActivity(intent2);
                }else if(position == 3) {
                    Toast.makeText(Event.this, "Charity For Palu", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(Event.this, Screen2.class);
                    intent3.putExtra("valueEvent", nameEvent[3]);
                    intent3.putExtra("value", name);
                    intent3.putExtra("valueGuest", guestName);
                    startActivity(intent3);
                }

            }
        });
    }

    class EventAdapter extends ArrayAdapter<String> {
        Context context;
        String currNameEvent[];
        String currDateEvent[];
        int[] imgs;

        EventAdapter(Context c, String[] nameEvent, String[] dateEvent, int[] images){
            super(c,R.layout.row, R.id.txtNameEvent, nameEvent);
            this.context = c;
            this.imgs = images;
            this.currNameEvent = nameEvent;
            this.currDateEvent = dateEvent;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.logo);
            TextView nameEvent = row.findViewById(R.id.txtNameEvent);
            TextView dateEvent = row.findViewById(R.id.txtDateEvent);
            images.setImageResource(imgs[position]);
            nameEvent.setText(currNameEvent[position]);
            dateEvent.setText(currDateEvent[position]);
            return row;
        }
    }
}
