package com.dekhoapp.android.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DekhoApp extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelperGrid helper;
    CustomAdapterGrid adapter;
    GridView gv;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.home_grid_layout);

        gv= (GridView) findViewById(R.id.grid_view);

        adapter=new CustomAdapterGrid(this,helper.retrive());
        gv.setAdapter(adapter);

        db= FirebaseDatabase.getInstance().getReference("Lokesh").child("Music");
        helper=new FirebaseHelperGrid(db);


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}