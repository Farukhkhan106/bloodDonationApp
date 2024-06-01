package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button donarbtn=findViewById(R.id.donarbtn);
        Button repobtn=findViewById(R.id.repobtn);
        donarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  i=new Intent(signUp.this,donarActivity.class);
                startActivity(i);
            }
        });

        repobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(signUp.this,repoActivity.class);
                startActivity(i);
            }
        });

    }

}