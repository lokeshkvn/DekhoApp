package com.dekhoapp.android.app.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL PC on 02-05-2017.
 */

public class CustomAdapterGrid extends RecyclerView.Adapter<CustomAdapterGrid.MyViewHolder> {

    Context c;
    ArrayList<MusicModel> musicModels;
    public CustomAdapterGrid(Context c, ArrayList<MusicModel> musicModels) {
        this.c = c;
        this.musicModels = musicModels;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MusicModel musicModel = musicModels.get(position);
        holder.title.setText(musicModel.getName());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return musicModels.size();
    }


}
