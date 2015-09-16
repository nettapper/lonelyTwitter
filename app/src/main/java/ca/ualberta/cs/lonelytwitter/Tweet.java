package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ccdunn on 9/16/15.
 */
public class Tweet {
    private String text;
    private Date date;

    public Tweet(String text, Date date){
        this.text = text;
        this.date = date;
    }

    public Tweet(String text){
        this.text = text;
        this.date = new Date(); // defaluts to current time
    }

    // Add some getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
