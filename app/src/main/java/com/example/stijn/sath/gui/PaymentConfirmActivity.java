package com.example.stijn.sath.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.stijn.sath.R;
import com.example.stijn.sath.domain.Seat;

import java.util.ArrayList;

/**
 * Created by btaks on 3-4-2018.
 */

public class PaymentConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirm);

        TextView text = (TextView) findViewById(R.id.a_payment_done_text);
        Button button = (Button) findViewById(R.id.a_payment_done_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent i = new Intent(getApplicationContext(), MainActivity.class);
             startActivity(i);
            }
        });
    }
}
