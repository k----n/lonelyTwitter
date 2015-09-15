package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

/**
 * Created by kalvin1 on 9/15/15.
 */
public interface Tweetable {
    public void setText(String text) throws IOException;
    public String getText();
}
