package com.example.android.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkCredentials(View v) {
        EditText userCtrl = (EditText)findViewById(R.id.text_uname);
        EditText passwordCtrl = (EditText)findViewById(R.id.edit_psswd);
        TextView errorText = (TextView)findViewById(R.id.lbl_Error);
        String userName = userCtrl.getText().toString();
        String password = passwordCtrl.getText().toString();

        boolean validationFlag = false;
        //Verify if the username and password are not empty

        if(!userName.isEmpty() && !password.isEmpty()){
            if(userName.equals("Admin")&& password.equals("Admin")){
                validationFlag = true;
            }
        }
        if(!validationFlag){
            errorText.setVisibility(View.VISIBLE);

        }
        else {
            //This code redirects from login page to homepage
            //reDirectToHomePage(v);
            Intent redirect = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(redirect);
        }
    }
}
