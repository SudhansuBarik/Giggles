package io.github.sudhansubarik.giggles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import io.github.sudhansubarik.javajoker.Joker;
import io.github.sudhansubarik.jokefactory.DisplayJokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment,new MainActivityFragment()).commit();
    }
}
