package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar mSpinner;
    private Button mButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mSpinner = (ProgressBar) root.findViewById(R.id.progressBar1);
        mSpinner.setVisibility(View.GONE);

        mButton = (Button) root.findViewById(R.id.click_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpinner.setVisibility(View.VISIBLE);
                new EndpointsAsyncTask(mSpinner).execute(new Pair<Context, String>(getContext(), "Manfred"));
            }
        });

        return root;
    }
}
