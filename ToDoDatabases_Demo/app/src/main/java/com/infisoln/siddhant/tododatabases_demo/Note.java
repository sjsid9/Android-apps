package com.infisoln.siddhant.tododatabases_demo;

public class Note {

    String title,content,timeStamp;
    int isDone,id;


    public Note(String title, String content, String timeStamp, int isDone) {
        this.title = title;
        this.content = content;
        this.timeStamp = timeStamp;
        this.isDone = isDone;
    }

    public Note(String title, String content, String timeStamp, int isDone, int id) {
        this.title = title;
        this.content = content;
        this.timeStamp = timeStamp;
        this.isDone = isDone;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
