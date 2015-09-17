package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ccdunn on 9/16/15.
 */
public class ImportantTweet extends Tweet {
    public ImportantTweet(String text, Date date) {
        super(text, date);
    }

    public ImportantTweet(String text) {
        super(text);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    public String getText(){
        return "!!!" + super.getText();
    }
}
