package com.dekhoapp.android.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DekhoApp extends AppCompatActivity {

    DatabaseReference db;


    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.song_listview);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager((this));
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        db= FirebaseDatabase.getInstance().getReference();
        FirebaseHelperGrid helper=new FirebaseHelperGrid(db);

        CustomAdapterGrid adapter=new CustomAdapterGrid(DekhoApp.this,helper.retrive());
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}