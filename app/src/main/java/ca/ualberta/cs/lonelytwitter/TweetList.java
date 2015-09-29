package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by kalvin1 on 9/29/15.
 */
public class TweetList {
    private Tweet mostRecentTweet;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) throws IllegalArgumentException {

        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Duplicate Tweet!");
        }
        else {
            mostRecentTweet = tweet;
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    public Boolean hasTweet(Tweet tweet){
        if (tweets.contains(tweet)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void removeTweet(Tweet tweet) throws IllegalArgumentException{
        if (hasTweet(tweet)){
            tweets.remove(tweet);
        }
        else {
            throw new IllegalArgumentException("Does not exist!");
        }

    }

    public Tweet getMostRecentTweet(){
        return mostRecentTweet;
    }

    public int getCount() {
        return tweets.size();
    }
}
