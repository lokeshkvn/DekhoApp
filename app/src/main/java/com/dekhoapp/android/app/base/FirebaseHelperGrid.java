package com.dekhoapp.android.app.base;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by DELL PC on 02-05-2017.
 */

public class FirebaseHelperGrid {
    DatabaseReference db;
    Boolean saved=null;
    ArrayList<MusicModel> musicModel=new ArrayList<>();

    public FirebaseHelperGrid(DatabaseReference db) {
        this.db = db;
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        musicModel.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            MusicModel MusicName =ds.getValue(MusicModel.class);
            musicModel.add(MusicName);
        }

        for (MusicModel s : musicModel){
            Log.d("music content : ", s.name);
        }

    }

    public ArrayList<MusicModel> retrive(){

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return  musicModel;
    }

}
