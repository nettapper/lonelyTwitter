package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by ccdunn on 9/30/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    /*
    Steps in Test Driven Dev

    1. Write tests that fail
    2. Write code for the tests
    3. Run tests and goto 2 until they pass
    4. goto 1

    Note: test aren't going to run sequentially
     */

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testDeleteTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("del me");
        tweetList.add(tweet);
        tweetList.delete(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("del me");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("del me");
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testTweetCount(){

    }

    public void testGetTweet(){

    }

    public void testGetTweetType(){

    }
}