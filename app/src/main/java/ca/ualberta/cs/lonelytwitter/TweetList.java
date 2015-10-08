package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by ccdunn on 9/30/15.
 */
public class TweetList implements MyObservable {
   private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
   private ArrayList<MyObserver> myObservers = new ArrayList<MyObserver>();

   public void add(Tweet tweet) {
      tweets.add(tweet);
      notifyObservers();
   }

   public void delete(Tweet tweet) {
      tweets.remove(tweet);
   }

   public Tweet getTweet(int index) {
      return tweets.get(index);
   }

   public int count() {
      return tweets.size();
   }

   /*
   Lab Assn

   addTweet() -- should throw an IllegalArgumentException when one tries to add a duplicate tweet
   getTweets() -- should return a list of tweets in chronological order
   hasTweet() -- should return true if there is a tweet that equals() another tweet
   removeTweet() -- should remove a tweet
   getCount() -- should accurately count up the tweets
   */
   public void addTweet(Tweet tweet) throws IllegalArgumentException {
      if(!this.hasTweet(tweet)){
         tweets.add(tweet);
         notifyObservers();
      } else throw new IllegalArgumentException();
   }

   public ArrayList<Tweet> getTweets() {
      // todo: need to impliment
      return null;
   }

   public boolean hasTweet(Tweet tweet) {
      return tweets.contains(tweet);
   }

   public void removeTweet(Tweet tweet){
      this.delete(tweet);
   }

   public int getCount(){
      return this.count();
   }

   public void addObserver(MyObserver observer) {
      myObservers.add(observer);
   }

   public void notifyObservers() {
      for (MyObserver o:myObservers) {
         o.myNotify();
      }
   }
}
