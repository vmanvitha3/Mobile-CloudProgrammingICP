package com.example.android.myorder;

//import android.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        boolean flag = true;
        Intent intent = getIntent();

        String message = intent.getStringExtra("message");

        // Capture the layout's TextView and set the string as its text
        TextView txtView = (TextView)findViewById(R.id.view_summary);

        if(flag) {
            txtView.setText(message);
            
        }
    }
}
