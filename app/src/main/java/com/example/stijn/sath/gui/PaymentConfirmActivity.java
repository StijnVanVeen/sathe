package com.example.stijn.sath.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.stijn.sath.R;

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
    }
}
