package com.dekhoapp.android.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by DELL PC on 02-05-2017.
 */

public class SelectMusicClass extends AppCompatActivity {

ListView listView;
    DatabaseReference dref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_listview);
        listView=(ListView)findViewById(R.id.recycler_view);
        dref= FirebaseDatabase.getInstance().getReference("Lokesh").child("Music").child("English");
        dref.addChildEventListener(new ChildEventListener() {

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        dataSnapshot.getValue();
        System.out.println("The song  has been added");
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s){

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        dataSnapshot.getValue();
        System.out.println("The song  has been deleted");
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

    }
}
