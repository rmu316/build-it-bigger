package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.richardmu.backend.myApi.MyApi;
import com.example.richardmu.jokedisplay.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Richard Mu on 8/13/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private final String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    private Context context;
    private Exception mError = null;
    private AsyncTaskListener mTaskListener = null;
    private ProgressBar mSpinner = null;

    // Constructor #1: Normal case where we pass in Progress bar
    // so that when we fetch the joke, we set the bar to invisible
    public EndpointsAsyncTask(ProgressBar spinner) {
        mSpinner = spinner;
    }

    // Constructor #2: for test cases, we want notify the test class
    // when we finish using an async task listener
    public EndpointsAsyncTask(AsyncTaskListener atl) {
        mTaskListener = atl;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.0.250:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // If we initialized EndpointsAsyncTask from
        // our test class, AsyncTaskTest, we signify
        // it that we have retrieved a joke
        if (this.mTaskListener != null) {
            this.mTaskListener.finishedTask(result, mError);
        }
        // If we initialized EndpointsAsyncTask from
        // our activity fragement, we signify its
        // ProgressBar to go invisible
        if (this.mSpinner != null) {
            this.mSpinner.setVisibility(View.GONE);
        }
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, result);
        context.startActivity(intent);
    }

    @Override
    protected void onCancelled() {
        // in the case this task failed and we initialized it
        // from our test class, we notify it of an error
        if (this.mTaskListener != null) {
            mError = new InterruptedException("AsyncTask cancelled");
            this.mTaskListener.finishedTask(null, mError);
        }
    }
}
