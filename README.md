# TweetComposer
How to install.
Get fabric_key, twitter_key, and twitter_secret_key.
Use this code in command line
cordova plugin add <Your plugin location> —variable FABRIC_KEY=<your fabric key>
 Open config.xml (in your project's root) and add these two lines before the closing </widget> tag:
<preference name="TwitterConsumerKey" value="<twitter_key>" />
<preference name="TwitterConsumerSecret" value="<twitter_secret_key>" />
Done!

How to use.
in *.js
var success = function() { alert("Success"); };
var error = function(message) { alert("Oopsie! " + message); };     
var tweet = cordova.require("com.attendee.tweet.tweetComposer");
tweet.tweetMessage(success,error,'Android101');
