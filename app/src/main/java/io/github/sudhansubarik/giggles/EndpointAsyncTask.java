package io.github.sudhansubarik.giggles;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import io.github.sudhansubarik.giggles.backend.myApi.MyApi;
import io.github.sudhansubarik.jokefactory.DisplayJokeActivity;

class EndpointAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {

    private static MyApi myApiService = null;
    private Context context;
//    private MainActivityFragment mainActivityFragment;

    EndpointAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(MainActivityFragment... params) {

//        mainActivityFragment = params[0];
//        context = mainActivityFragment.getActivity();

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setRootUrl("http://localhost:8080")
//                    .setRootUrl("https://giggles-224216.appspot.com/_ah/api/");
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

//        mainActivityFragment.loadedJoke = result;
//        mainActivityFragment.launchDisplayJokeActivity();

        Log.e("JOKE", result);

        try {
            Intent intent = new Intent(context, DisplayJokeActivity.class);
            intent.putExtra(DisplayJokeActivity.JOKE_INTENT, "JOKE: " + result);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}