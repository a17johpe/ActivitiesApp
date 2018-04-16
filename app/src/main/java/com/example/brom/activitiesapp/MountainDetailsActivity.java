package com.example.brom.activitiesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String selectedMountain = intent.getStringExtra("Name");
        String mountainData = intent.getStringExtra("Info");

        TextView textView = (TextView) findViewById(R.id.info_text);
        TextView textView1 = (TextView) findViewById(R.id.title_text);
        textView1.setText(selectedMountain);
        textView.setText(mountainData);
    }

}
