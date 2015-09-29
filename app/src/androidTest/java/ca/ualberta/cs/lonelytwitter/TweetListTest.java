package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kalvin1 on 9/29/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testHoldsStuff(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        assertSame(list.getMostRecentTweet(), tweet);

    }

    public void testAddingThings(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        try
        {
            list.addTweet(tweet);
            Assert.fail("Duplicate Tweet!");
        }
        catch(IllegalArgumentException e){
            //success
        }

    }

    public void testGettingThings(){
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("test");
        list.addTweet(tweet1);
        Tweet tweet2 = new NormalTweet("test");
        list.addTweet(tweet2);
        ArrayList<Tweet> list2 = list.getTweets();
        assertEquals(list2.get(0),tweet1);
        assertEquals(list2.get(1),tweet2);
    }

    public void testCheckingThings(){
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("test");
        list.addTweet(tweet1);
        assertEquals(list.hasTweet(tweet1),Boolean.TRUE);
    }


    public void testRemovingThings(){
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("test");
        list.addTweet(tweet1);
        assertEquals(list.hasTweet(tweet1), Boolean.TRUE);
        list.removeTweet(tweet1);
        assertEquals(list.hasTweet(tweet1), Boolean.FALSE);
    }

    public void testHoldsManyThings(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        assertEquals(list.getCount(), 1);
        list.addTweet(new NormalTweet("test1"));
        assertEquals(list.getCount(), 2);
    }

}