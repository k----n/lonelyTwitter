package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private EditText bodyText;
    private Button saveButton;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditATweet() {
        // starts lonelyTwitter
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();

        // reset the app to a known state
        activity.getTweets().clear();

        // user clicks on tweet they want to edit
        bodyText = activity.getBodyText();

        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText("hamburgers");
            }
        });
        getInstrumentation().waitForIdleSync(); // make sure or UI thread finishes

        saveButton = activity.getSaveButton();

        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync(); // make sure or UI thread finishes

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("hamburgers", tweet.getText());

        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList.getChildAt(0);
                oldTweetList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync(); // make sure or UI thread finishes


        // Validate that ReceiverActivity is started
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for EditTweetActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        // test that the tweet being shown on the edit screen is the tweet
        // we clicked on


        //edit the text of the tweet

        //save our edits

        // assert that out edits were saved into tweet correctly

        // assert that out edits are shown on the screen to the user
        // back in the main activity




        receiverActivity.finish();
    }
}