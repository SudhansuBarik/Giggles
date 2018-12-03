package io.github.sudhansubarik.giggles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import io.github.sudhansubarik.jokefactory.DisplayJokeActivity;

public class MainActivityFragment extends Fragment {
    ProgressBar progressBar;
    public String loadedJoke;
    public boolean testFlag = false;

    public MainActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView adView = root.findViewById(R.id.adView);

        // Set onClickListener for the button
        Button button = root.findViewById(R.id.joke_btn);
        button.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                getJoke();
            }
        });

        progressBar = root.findViewById(R.id.joke_progressBar);
        progressBar.setVisibility(View.GONE);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
        return root;
    }

    public void getJoke() {
        new EndpointAsyncTask(getContext()).execute(this);
    }

    public void launchDisplayJokeActivity() {
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, DisplayJokeActivity.class);
            assert context != null;
            intent.putExtra(context.getString(R.string.jokeEnvelope), loadedJoke);
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
    }
}
