package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kalvin1 on 9/15/15.
 */
public abstract class Mood {
    private String mood;
    private Date date;

    public Mood() {
        this.date = new Date();
    }

    public Mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
