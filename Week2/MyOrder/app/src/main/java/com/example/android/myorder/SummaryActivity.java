package com.example.android.myorder;

//import android.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent intent = getIntent();

        String message = intent.getStringExtra("message");

        // Capture the layout's TextView and set the string as its text
        TextView txtView = (TextView) findViewById(R.id.view_summary);
        ImageView img1 = (ImageView) findViewById(R.id.view_pepperoni);
        ImageView img2 = (ImageView) findViewById(R.id.view_mushrooms);
        ImageView img3 = (ImageView) findViewById(R.id.view_cheese);
        ImageView img4 = (ImageView) findViewById(R.id.view_olives);

        if (intent.getBooleanExtra("pepperoni", false)) {
            img1.setVisibility(View.VISIBLE);
        }
        if(intent.getBooleanExtra("mushrooms",false)) {
            img2.setVisibility(View.VISIBLE);
        }
        if(intent.getBooleanExtra("extracheese",false)) {
            img3.setVisibility(View.VISIBLE);
        }
        if(intent.getBooleanExtra("olives",false)) {
            img4.setVisibility(View.VISIBLE);
        }
        txtView.setText(message);

    }
}
