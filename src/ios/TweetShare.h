//
//  TweetShare.h
//  HelloCordova
//
//  Created by Pongnat Phognan on 2/18/2559 BE.
//
//


#import <Cordova/CDV.h>

@interface TweetShare :CDVPlugin

- (void)tweetComposer:(CDVInvokedUrlCommand*)command;

@end
