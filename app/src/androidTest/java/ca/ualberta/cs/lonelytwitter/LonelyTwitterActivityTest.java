package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditTweet(){
        // when you call getActivity android will start the app and the ...
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();

        // reset the app to a know state
        activity.getTweets().clear();

        // add a tweet
        EditText bodyText = activity.getBodyText();
        bodyText.setText("Test Tweet");

        Button saveButton = activity.getSaveButton();
        saveButton.performClick();

        // make sure the tweet was actually added
        ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet", tweet.getText());
    }
}