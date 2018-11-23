package com.example.yulindraadjie.suitmedia1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Guest extends AppCompatActivity {

    private String URL = "http://dry-sierra-6832.herokuapp.com/api/people";
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private ArrayList<GuestModel> listGuest;

    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        listGuest = new ArrayList<GuestModel>();
        getDataGuest();
        recyclerViewAdapter = new RecyclerViewAdapter(this,listGuest);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();
    }

    public void getDataGuest(){
        JsonArrayRequest arrayRequest = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response.length()>0){
                    for(int i=0; i<response.length(); i++){
                        try{
                            JSONObject data=response.getJSONObject(i);
                            GuestModel gm = new GuestModel();
                            gm.setId(data.getInt("id"));
                            gm.setName(data.getString("nameGuest"));
                            gm.setBirthdate(data.getString("birthdayGuest"));
                            listGuest.add(gm);
                            recyclerViewAdapter.notifyDataSetChanged();
                        }catch (JSONException e){

                        }
                    }
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ); Volley.newRequestQueue(this).add(arrayRequest);
    }
}
