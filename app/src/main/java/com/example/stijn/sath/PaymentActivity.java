package com.example.stijn.sath;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by btaks on 30-3-2018.
 */

public class PaymentActivity extends AppCompatActivity {
    public TextView desc;
    public TextView name;
    public TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);

        setButtons();
    }

    private void setButtons() {
        RadioGroup choices = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton iDeal = (RadioButton) findViewById(R.id.option_iDeal);
        RadioButton payPal = (RadioButton) findViewById(R.id.option_PayPal);
        RadioButton creditCard = (RadioButton) findViewById(R.id.option_CreditCard);

        final TextView desc = (TextView) findViewById(R.id.payment_chosen);
        final TextView name = (TextView) findViewById(R.id.payment_name);
        EditText inputName = (EditText) findViewById(R.id.payment_input_name);
        final TextView pass = (TextView) findViewById(R.id.payment_password_acc);
        EditText inputPass = (EditText) findViewById(R.id.payment_input_password_acc);

        iDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desc.setText("Paying with iDeal requires you to input your bank account owner's name and number.");
                name.setText("Input your bank account owner's name here.");
                pass.setText("Input your bank account number here.");
            }
        });

        payPal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desc.setText("Paying with PayPal requires you to input your PayPal account username and password.");
                name.setText("Input your username here.");
                pass.setText("Input your password here.");
            }
        });

        creditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desc.setText("Paying with CreditCard requires you to input your creditcard owner's name and number.");
                name.setText("Input your creditcard owner's name here.");
                pass.setText("Input your creditcard number here.");
            }
        });
    }
}
