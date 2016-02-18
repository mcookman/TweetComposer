
// Defining Plugin As A Cordova Module

var tweetComposerPlugin = {
	tweetMessage: function(successCallback, errorCallback,text){
		cordova.exec(successCallback, errorCallback,'tweetComposer','tweetComposer',[text])
	}
}

module.exports = tweetComposerPlugin;