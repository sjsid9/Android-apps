package com.infisoln.siddhant.asynctask_networking;

public class Item {

    private String login,id,avatr_url,url,score;

    public Item(String login, String id, String avatr_url, String url, String score) {
        this.login = login;
        this.id = id;
        this.avatr_url = avatr_url;
        this.url = url;
        this.score = score;
    }

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

}
