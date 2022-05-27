package com.example.WasteFoodManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Button donate = (Button) findViewById(R.id.donate);
//        donate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SecondActivity.this,DonateActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Button recieve = (Button) findViewById(R.id.recieve);
//        recieve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SecondActivity.this,RetrieveListActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    public void openRetrieveListActivity(View view) {
        Intent intent = new Intent(SecondActivity.this,RetrieveListActivity.class);
        startActivity(intent);



    }

    public void openDonateActivity(View view) {
        Intent intent = new Intent(SecondActivity.this,DonateActivity.class);
        startActivity(intent);
    }
}
