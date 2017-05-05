package com.dekhoapp.android.app.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL PC on 02-05-2017.
 */

public class CustomAdapterGrid extends BaseAdapter {

    Context c;
    ArrayList<MusicModel> musicModels;
    public CustomAdapterGrid(Context c, ArrayList<MusicModel> musicModels) {
        this.c = c;
        this.musicModels = musicModels;
    }

    public CustomAdapterGrid() {
        super();
    }

    @Override
    public int getCount() {
        return musicModels.size();
    }

    @Override
    public Object getItem(int i) {
        return musicModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.single_grid,viewGroup,false);
        }
        TextView nameTxt= (TextView) view.findViewById(R.id.music_name);

        final MusicModel s= (MusicModel) this.getItem(i);
        nameTxt.setText(s.getName());

        return view;
    }
}
