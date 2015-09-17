package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ccdunn on 9/16/15.
 */
public abstract class Tweet implements Tweetable {
    // can force a property, eg. implements comparable allows tweets to be sorted
    private String text;
    private Date date;
    private ArrayList<CurrentMood> listOfMoods;

    public Tweet(String text, Date date){
        try {
            this.setText(text);
        } catch (IOException e) {
            // do something with e...

            // if you need to catch the exception but don't know how to handle it...
            // just raise the exception
            throw new RuntimeException(e);
        }
        this.date = date;
    }

    public Tweet(String text){
        this.text = text;
        this.date = new Date(); // defaluts to current time
    }

    public abstract Boolean isImportant();

    public ArrayList<CurrentMood> getListOfMoods(){
        return this.listOfMoods;
    }

    // Add some getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException {
        if(text.length() <= 140) {
            this.text = text;
        } else {
            // throw new IllegalArgumentException("Tweet was too long!");
            // lets use a runtime exception instead and handle it
            throw new IOException("Tweet was too long!");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
