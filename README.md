# TweetComposer
##How to install.
* Get fabric_key, twitter_key, and twitter_secret_key.
* Use this code in command line.<br/>
`cordova plugin add <Your plugin location> —variable FABRIC_KEY= <your fabric key>`
* Open config.xml (in your project's root) and add these two lines before the closing `</widget>` 
tag:
`<preference name="TwitterConsumerKey" value="<twitter_key>" />`<br/>
`<preference name="TwitterConsumerSecret" value="<twitter_secret_key>" />`<br/>
####Done!

##How to use.
``````
in *.js<br/>
var success = function() { alert("Success"); };<br/>
var error = function(message) { alert("Oopsie! " + message); };<br/>
var tweet = cordova.require("com.attendee.tweet.tweetComposer");<br/>
tweet.tweetMessage(success,error,'Android101');
``````