package io.github.sudhansubarik.jokefactory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {
    public static String JOKE_INTENT = "Joke_Intent ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        if (getIntent().hasExtra(JOKE_INTENT)) {
            String joke = getIntent().getStringExtra(JOKE_INTENT);
            TextView textView = findViewById(R.id.joke_text);
            textView.setText(joke);
        }
    }
}
