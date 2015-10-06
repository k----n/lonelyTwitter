package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by kalvin1 on 9/29/15.
 */
public class TweetList implements MyObservable, MyObserver{
    private Tweet mostRecentTweet;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) throws IllegalArgumentException {

        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Duplicate Tweet!");
        }
        else {
            mostRecentTweet = tweet;
            tweets.add(tweet);
            tweet.addObserver(this);
            notifyAllObservers();
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

    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void addObserver(MyObserver observer){
        observers.add(observer);
    }

    private void notifyAllObservers(){
        for (MyObserver observer : observers){
            observer.myNotify(this);
        }
    }

    public void myNotify(MyObservable observable){
        notifyAllObservers();
    }
}
