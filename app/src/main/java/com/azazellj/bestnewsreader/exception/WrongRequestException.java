package com.azazellj.bestnewsreader.exception;

/**
 * Created by azazellj on 3/1/16.
 */
public class WrongRequestException extends Exception {
    public WrongRequestException(String requestUrl) {
        super(String.format("Something is wrong with this URL: %s", requestUrl));
    }
}