package com.mechanitis.demo.sense.twitter;

/**
 * Created by davidsuarez on 7/21/17.
 */
public interface TweetParser {

    static String getTweetMessageFrom(String fullTweet) {
        String textFieldName = "\"text\":\"";
        String nextFieldName = "\"source\":\"";
        int indexOfEndOfTextField = fullTweet.indexOf(textFieldName) + textFieldName.length();
        int indexOfEndOfText = fullTweet.indexOf(nextFieldName);
        return fullTweet.substring(indexOfEndOfTextField, indexOfEndOfText);
    }

    static String getTwitterHandleFromTweet(String fullTweet) {
        String twitterHandleFieldName = "\"screen_name\":\"";
        int indexOfTwitterHandleField = fullTweet.indexOf(twitterHandleFieldName)+ twitterHandleFieldName.length();
        int indexOfEndOfTwitterHandle = fullTweet.indexOf("\"", indexOfTwitterHandleField);
        return fullTweet.substring(indexOfTwitterHandleField, indexOfEndOfTwitterHandle);
    }

}
