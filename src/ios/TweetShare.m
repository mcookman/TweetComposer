//
//  TweetShare.m
//  HelloCordova
//
//  Created by Pongnat Phognan on 2/18/2559 BE.
//
//

#import "TweetShare.h"
#import <Fabric/Fabric.h>
#import <TwitterKit/TwitterKit.h>
#import <Cordova/CDV.h>
@implementation TweetShare


-(void)initTwitter{
    NSString *twitterKey = [self.commandDelegate.settings objectForKey:[@"TwitterConsumerKey" lowercaseString]];
    NSString *twitterSecret = [self.commandDelegate.settings objectForKey:[@"TwitterConsumerSecret" lowercaseString]];
    [[Twitter sharedInstance] startWithConsumerKey:twitterKey consumerSecret:twitterSecret];
    [Fabric with:@[[Twitter sharedInstance]]];
    [Fabric with:@[TwitterKit]];
}

-(void)tweetComposer:(CDVInvokedUrlCommand *)command{
    
    [self initTwitter];
    
    __block CDVPluginResult *pluginResult = nil;
    NSString *text = [command argumentAtIndex:0];
    
    TWTRComposer *composer = [[TWTRComposer alloc] init];
    [composer setText:text];
    
    // Called from a UIViewController
    [composer showFromViewController:[self viewController] completion:^(TWTRComposerResult result) {
        if (result == TWTRComposerResultCancelled) {
            NSLog(@"Tweet composition cancelled");
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"cancle"];
        }
        else {
            NSLog(@"Sending Tweet!");
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"sended"];
        }
    }];

    
    
}

@end
