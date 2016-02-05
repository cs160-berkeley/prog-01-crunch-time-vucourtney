package com.example.courtneyvu.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    /** Called when the user clicks the top button */
    public void startMainConverter(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainScreenConverter.class);
        startActivity(intent);
    }

    /** Called when the user clicks the bottom button */
    public void startSecondaryConverter(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SecondaryScreenConverter.class);
        startActivity(intent);
    }


}
