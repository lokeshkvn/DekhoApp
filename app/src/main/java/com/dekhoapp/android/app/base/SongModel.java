package com.dekhoapp.android.app.base;

/**
 * Created by DELL PC on 03-05-2017.
 */

public class SongModel {
    String name , url , url_gs;

    public SongModel(String name, String url, String url_gs) {
        this.name = name;
        this.url = url;
        this.url_gs = url_gs;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getUrl_gs() {
        return url_gs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrl_gs(String url_gs) {
        this.url_gs = url_gs;
    }
}
