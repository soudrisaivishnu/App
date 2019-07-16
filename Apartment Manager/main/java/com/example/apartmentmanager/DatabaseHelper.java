package com.example.apartmentmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "Detailsdb";
    private static int DATABASE_VERSION = 1;

    private static String TABLE_NAME = "Details";
    private static String KEY_USERNAME = "username";
    private static String KEY_PASSWORD = "password";
    private static String KEY_EMAIL_ID = "emailid";
    private static String KEY_PHONENUMBER = "phoneNo";
    private static String KEY_ADDRESS = "address";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    String CreateTable = "CREATE TABLE "+TABLE_NAME+"( "+KEY_USERNAME+" TEXT PRIMARY KEY, "+KEY_PASSWORD+" TEXT, "+KEY_EMAIL_ID+" TEXT, "+KEY_PHONENUMBER+" TEXT, "+KEY_ADDRESS+" TEXT)";
     db.execSQL(CreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addDetails(Details details)
    {
    SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
    values.put(KEY_USERNAME,details.username);
    values.put(KEY_PASSWORD,details.password);
    values.put(KEY_EMAIL_ID,details.emailid);
    values.put(KEY_PHONENUMBER,details.phoneNo);
    values.put(KEY_ADDRESS,details.address);

db.insert(TABLE_NAME,null,values);
db.close();
    }

    Details getDetails(String username) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_USERNAME, KEY_PASSWORD, KEY_EMAIL_ID, KEY_PHONENUMBER, KEY_ADDRESS},
                KEY_USERNAME + "=?", new String[]{String.valueOf(username)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            String idusername = cursor.getString(0);
            String idpassword = cursor.getString(1);

            Details d = new Details(idusername, idpassword, null, null, null);
            return d;

        }
        return null;
    }
}
