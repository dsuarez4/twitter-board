package com.mechanitis.demo.sense.mood;

import com.mechanitis.demo.sense.twitter.TweetParser;

import java.util.HashMap;
import java.util.Map;

import static com.mechanitis.demo.sense.mood.Mood.HAPPY;
import static com.mechanitis.demo.sense.mood.Mood.SAD;
import static com.mechanitis.demo.sense.twitter.TweetParser.getTweetMessageFrom;

/**
 * Created by davidsuarez on 7/19/17.
 */
public class MoodAnalyser {
    private static final Map<String, Mood> WORD_TO_MOOD = new HashMap<>();

    static {
        WORD_TO_MOOD.put("happy", HAPPY);
        WORD_TO_MOOD.put("good", HAPPY);
        WORD_TO_MOOD.put("great", HAPPY);
        WORD_TO_MOOD.put("keen", HAPPY);
        WORD_TO_MOOD.put("awesome", HAPPY);
        WORD_TO_MOOD.put("marvelous", HAPPY);
        WORD_TO_MOOD.put("yay", HAPPY);
        WORD_TO_MOOD.put("pleased", HAPPY);
        WORD_TO_MOOD.put("sad", SAD);
        WORD_TO_MOOD.put("mad", SAD);
        WORD_TO_MOOD.put("blargh", SAD);
        WORD_TO_MOOD.put("boo", SAD);
        WORD_TO_MOOD.put("terrible", SAD);
        WORD_TO_MOOD.put("horrible", SAD);
        WORD_TO_MOOD.put("bad", SAD);
        WORD_TO_MOOD.put("awful", SAD);
    }

    private MoodAnalyser() {
    }

    public static String analyseMood(String fullMessage) {
        String[] wordsInMessage = TweetParser.getTweetMessageFrom(fullMessage).split("\\s");
        //TODO: figureout the unique moods in this message and return as CSV
        return null;
    }
}
