package com.attendee.tweet;

import android.content.Context;
import android.content.Intent;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import io.fabric.sdk.android.Fabric;
/**
 * Created by Olipsist on 2/16/2016 AD.
 */
public class TweetShare extends CordovaPlugin {
    private Context context;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if(action.equals("tweetComposer")){
            context = this.cordova.getActivity().getBaseContext();
            initTwitter();
            String text = args.getString(0);
            this.tweet(text, callbackContext);
            return true;
        }
        return false;
    }

    private void initTwitter(){
        TwitterAuthConfig authConfig = new TwitterAuthConfig(getTwitterKey(), getTwitterSecret());
        Fabric.with(context, new Twitter(authConfig));
    }

    private void tweet(String text, CallbackContext callbackContext){
        if(text!=null && text.length() > 0){
            callbackContext.success("Success");
//            Tweet text this way use when startActivity outside Activity.
            Intent builder = new TweetComposer.Builder(context).text(text).createIntent();
            builder.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(builder);

        }else{
            callbackContext.error("Failed to tweet");
        }

    }

    private String getTwitterKey() {
        return preferences.getString("TwitterConsumerKey", "");
    }

    private String getTwitterSecret() {
        return preferences.getString("TwitterConsumerSecret", "");
    }

}
