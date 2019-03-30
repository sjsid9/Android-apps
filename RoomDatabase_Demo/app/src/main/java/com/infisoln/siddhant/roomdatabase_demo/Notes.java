package com.infisoln.siddhant.roomdatabase_demo;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "notesTable")
public class Notes {

    private String title;

    private String description;

    @ColumnInfo(name = "time")
    private
    String timeStamp;

    private Boolean isDone;

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String completeBy;

    public Notes(String title, String description, String timeStamp, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;
        this.isDone = isDone;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompleteBy() {
        return completeBy;
    }

    public void setCompleteBy(String completeBy) {
        this.completeBy = completeBy;
    }

}
