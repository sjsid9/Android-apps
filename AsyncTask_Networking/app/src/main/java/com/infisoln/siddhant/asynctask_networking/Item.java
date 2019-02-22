package com.infisoln.siddhant.asynctask_networking;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private String login,id,avatr_url,url,score;

    public Item(String login, String id, String avatr_url, String url, String score) {
        this.login = login;
        this.id = id;
        this.avatr_url = avatr_url;
        this.url = url;
        this.score = score;
    }

    protected Item(Parcel in) {
        login = in.readString();
        id = in.readString();
        avatr_url = in.readString();
        url = in.readString();
        score = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatr_url() {
        return avatr_url;
    }

    public void setAvatr_url(String avatr_url) {
        this.avatr_url = avatr_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(id);
        dest.writeString(avatr_url);
        dest.writeString(url);
        dest.writeString(score);
    }
}
