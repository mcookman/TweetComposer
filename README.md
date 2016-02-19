# TweetComposer
##Compatible
iOS Version <= 7.0<br/>
Android Version <= 4.0


##How to install.
* Get fabric_key, twitter_key, and twitter_secret_key.
* Use this code in command line.<br/>
`cordova plugin add tweet-composer —variable FABRIC_KEY= <your fabric key>`
* Open config.xml (in your project's root) and add these two lines before the closing `</widget>` tag <br/> 
`<preference name="TwitterConsumerKey" value="<twitter_key>" />`<br/>
`<preference name="TwitterConsumerSecret" value="<twitter_secret_key>" />`<br/>
Done!

##How to use.
``````
in *.js
var success = function() { alert("Success"); };
var error = function(message) { alert("Oopsie! " + message); };
var tweet = cordova.require("com.attendee.tweet.tweetComposer");
tweet.tweetMessage(success,error,'Android101');
``````