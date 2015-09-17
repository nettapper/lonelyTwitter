package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ccdunn on 9/16/15.
 */
public interface Tweetable {
    // abstract class on steriods
    // usually named according to verbs
    // a list of methods w/o implimentation details
    public String getText();
    public Date getDate();
}
