package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kalvin1 on 9/15/15.
 */
public class SadMood extends Mood {
    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String getMood() {
        return "Sad";
    }
}
