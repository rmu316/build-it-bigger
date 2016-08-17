package com.udacity.gradle.builditbigger;

/**
 * Created by Richard Mu on 8/13/2016.
 */
public interface AsyncTaskListener {

    void finishedTask(String joke, Exception e);
}
