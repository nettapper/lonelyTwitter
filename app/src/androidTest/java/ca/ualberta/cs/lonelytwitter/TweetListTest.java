package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

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

    public void testDelete(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweetList.add(tweet);
        tweetList.delete(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }


    public void testAdd(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testCount(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweetList.add(tweet); // 1
        Tweet tweet2 = new NormalTweet("test tweet");
        tweetList.add(tweet2); // 2
        Tweet tweet3 = new NormalTweet("test tweet");
        tweetList.add(tweet3); // 3
        assertEquals(tweetList.count(), 3);
        tweetList.delete(tweet); // should delete one tweet
        assertEquals(tweetList.count(), 2);

    }

    public void testGetTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweetList.add(tweet);
        Tweet returnedTweet = tweetList.getTweet(0);
        assertTrue((tweet.date.equals(returnedTweet.date)) && tweet.getText().equals(returnedTweet.getText()));
    }

    public void testGetTweetType(){
    }

   /*
   Lab Assn

   addTweet() -- should throw an IllegalArgumentException when one tries to add a duplicate tweet
   getTweets() -- sould return a list of tweets in chronological order
   hasTweet() -- should return true if there is a tweet that equals() another tweet
   removeTweet() -- should remove a tweet
   getCount() -- should accurately count up the tweets
   */

    public void testAddTweet() {
        TweetList tweetList = new TweetList();
        NormalTweet t = new NormalTweet("ksdjfks");
        tweetList.addTweet(t);
        assertEquals(tweetList.count(), 1); // need one tweet

        Boolean flag = false;
        try {
            tweetList.addTweet(new NormalTweet("ksdjfks"));
        } catch (IllegalArgumentException e){
            flag = true;
        }
        assertTrue(flag); // shouldn't catch an error when same tweet content is added

        Boolean newflag = false;
        try {
            tweetList.addTweet(t);
        } catch (IllegalArgumentException e){
            flag = true;
        }
        assertTrue(newflag); // should catch an error when same obj is added

    }

    public void testGetTweets() {
        TweetList tweetList = new TweetList();
        Tweet tweet2 = new NormalTweet("test tweet", new Date());  // created first and should have smaller date
        Tweet tweet = new NormalTweet("test tweet", new Date());
        tweetList.addTweet(tweet);
        tweetList.addTweet(tweet2);  // smaller date added second
        ArrayList<Tweet> list = tweetList.getTweets();

        assertTrue(list.get(0).getDate().before(list.get(1).getDate()));
    }

    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void removeTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
        tweetList.removeTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweetList = new TweetList();
        Tweet tweet2 = new NormalTweet("test tweet");
        Tweet tweet = new NormalTweet("test tweet");
        tweetList.addTweet(tweet);
        tweetList.addTweet(tweet2);
        assertEquals(tweetList.getCount(), 2);
    }
}
