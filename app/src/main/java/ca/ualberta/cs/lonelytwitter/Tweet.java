package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kalvin1 on 9/15/15.
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    private Date date;
    private ArrayList<Mood> moods;

    public ArrayList<Mood> getMoods() {
        return moods;
    }

    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text.length() <= 140){
            this.text = text;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tweet(String text) {
        this.text = text;
        this.date = new Date();
    }

    public Tweet(String tweet, Date date) {
        this.text = tweet;
        this.date = date;
    }

    public abstract Boolean isImportant();
}
