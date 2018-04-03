package com.example.stijn.sath.dataAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by stijn on 3-4-2018.
 */

public class ETicketDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eticket.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = ETicketDatabaseHelper.class.getSimpleName();

    public ETicketDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(TAG, "onCreate(): has started");
        String query = "CREATE TABLE ticket (ticketNummer INTEGER PRIMARY KEY, filmName TEXT NOT NULL, seat INTEGER, hall INTEGER)";
        try{
            sqLiteDatabase.execSQL(query);
        }catch (Exception e){
            Log.e(TAG, "onCreate() Failed");
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ticket");
        Log.i(TAG, "onUpgrade(): is being triggered, dropping database table..");
        try {
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Log.e(TAG, "onUpgrade(): Failed");
            e.printStackTrace();
        }
    }
}
