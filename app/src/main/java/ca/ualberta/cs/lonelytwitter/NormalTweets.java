package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ccdunn on 9/16/15.
 */
public class NormalTweets extends Tweet {

    public NormalTweets(String text, Date date) {
        super(text, date);
    }

    public NormalTweets(String text) {
        super(text);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
