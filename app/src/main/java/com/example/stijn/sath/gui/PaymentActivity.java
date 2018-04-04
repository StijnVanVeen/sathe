package com.example.stijn.sath.gui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.ETC1;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.stijn.sath.R;
import com.example.stijn.sath.dataAccess.ETicketDatabaseHelper;
import com.example.stijn.sath.domain.ETicket;
import com.example.stijn.sath.domain.Seat;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by btaks on 30-3-2018.
 */

public class PaymentActivity extends AppCompatActivity {
    public TextView desc;
    public TextView name;
    public TextView pass;
    public TextView paymentAmount;
    public String filmName;
    public ArrayList<Integer> filmseats;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
        Intent i = getIntent();
        filmName = i.getStringExtra("filmName");
        filmseats = i.getIntegerArrayListExtra("seatList");
        ETicketDatabaseHelper eTicketDatabaseHelper = new ETicketDatabaseHelper(getApplicationContext());
        database = eTicketDatabaseHelper.getWritableDatabase();
        setButtons();
    }

    private ArrayList createETickets(ArrayList<Integer> filmseats){
        Log.i("SSSSSSSSS", String.valueOf(filmseats.size()));
        ArrayList<ETicket> etickets = new ArrayList<>();
        Random ran = new Random();
        for (int s : filmseats){
            ETicket et = new ETicket(ran.nextInt(5000) + 1, s, 1, filmName);
            etickets.add(et);
        }
        return etickets;
    }

    private void setButtons() {
        final RadioGroup choices = (RadioGroup) findViewById(R.id.radio_group);
        final RadioButton iDeal = (RadioButton) findViewById(R.id.option_iDeal);
        final RadioButton payPal = (RadioButton) findViewById(R.id.option_PayPal);
        final RadioButton creditCard = (RadioButton) findViewById(R.id.option_CreditCard);

        final TextView desc = (TextView) findViewById(R.id.payment_chosen);
        final TextView name = (TextView) findViewById(R.id.payment_name);
        final EditText inputName = (EditText) findViewById(R.id.payment_input_name);
        final TextView pass = (TextView) findViewById(R.id.payment_password_acc);
        final EditText inputPass = (EditText) findViewById(R.id.payment_input_password_acc);

        Button confirmBtn = (Button) findViewById(R.id.payment_confirm);

        paymentAmount = (TextView) findViewById(R.id.payment_amount);
        int price = filmseats.size() * 8;
        paymentAmount.setText(String.valueOf(price));


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

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iName = inputName.getText().toString();
                String iPass = inputPass.getText().toString();
                if (choices.getCheckedRadioButtonId() == iDeal.getId()) {
                    if (!iName.isEmpty() && iPass.matches("[A-Z0-9]*")) {
                        Intent i = new Intent(getApplicationContext(), PaymentConfirmActivity.class);
                        ArrayList<ETicket> etics = createETickets(filmseats);
                        for (ETicket e : etics){
                            ContentValues cv = new ContentValues();
                            cv.put("ticketNummer", e.getTicketNumber());
                            cv.put("filmName", e.getFilm());
                            cv.put("seat", e.getSeatNumber());
                            cv.put("hall", e.getHallNumber());
                            database.insert("ticket", null, cv);
                        }
                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), PaymentFailActivity.class);
                        startActivity(i);
                    }
                } else if (choices.getCheckedRadioButtonId() == payPal.getId()) {
                    if (iName.matches("^(.+)@(.+)$") && !iPass.isEmpty()) {
                        Intent i = new Intent(getApplicationContext(), PaymentConfirmActivity.class);
                        ArrayList<ETicket> etics = createETickets(filmseats);
                        for (ETicket e : etics){
                            ContentValues cv = new ContentValues();
                            cv.put("ticketNummer", e.getTicketNumber());
                            cv.put("filmName", e.getFilm());
                            cv.put("seat", e.getSeatNumber());
                            cv.put("hall", e.getHallNumber());
                            database.insert("ticket", null, cv);
                        }
                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), PaymentFailActivity.class);
                        startActivity(i);
                    }
                } else if (choices.getCheckedRadioButtonId() == creditCard.getId()) {
                    if (!iName.isEmpty() && iPass.matches("[0-9]+")) {
                        Intent i = new Intent(getApplicationContext(), PaymentConfirmActivity.class);
                        ArrayList<ETicket> etics = createETickets(filmseats);
                        for (ETicket e : etics){
                            ContentValues cv = new ContentValues();
                            cv.put("ticketNummer", e.getTicketNumber());
                            cv.put("filmName", e.getFilm());
                            cv.put("seat", e.getSeatNumber());
                            cv.put("hall", e.getHallNumber());
                            database.insert("ticket", null, cv);
                        }
                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), PaymentFailActivity.class);
                        startActivity(i);
                    }
                }
            }
        });
    }

    //adds custom menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.available_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent i;
        switch(id){
            case R.id.mnuMyTickets:
                i = new Intent(getApplicationContext(), ETicketActivity.class);
                startActivity(i);
                break;
            case R.id.mnuFilms:
                break;
            case R.id.mnuContact:
                i = new Intent(getApplicationContext(), CinemaAboutActivity.class);
                startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
