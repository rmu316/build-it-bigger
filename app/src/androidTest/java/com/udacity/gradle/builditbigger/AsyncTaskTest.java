package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Richard Mu on 8/13/2016.
 */
public class AsyncTaskTest extends AndroidTestCase implements AsyncTaskListener {

    private String mJoke;
    private Exception mException;
    // Synchronization aid to halt this thread while EndpointsAsyncTask
    // finishes its task
    private CountDownLatch mCountdownLatchSignal;

    @Override
    protected void setUp() throws Exception {
        mCountdownLatchSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        mCountdownLatchSignal.countDown();
    }


    public void testAsyncTask() throws InterruptedException {
        EndpointsAsyncTask theRunner = new EndpointsAsyncTask(this);
        theRunner.execute(new Pair<Context, String>(getContext(), "Richard"));
        // wait for EndpointsAsyncTask to finish, sleep
        mCountdownLatchSignal.await();

        assertNull("An exception occurred", this.mException);
        assertNotNull("Joke is null.", this.mJoke);
    }

    @Override
    public void finishedTask(String joke, Exception e) {
        this.mJoke = joke;
        this.mException = e;
        // called by EndpointsAsyncTask to wake up this thread
        this.mCountdownLatchSignal.countDown();
    }
}
