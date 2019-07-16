package com.example.databasetesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.databasetesting.Contacts;

public class MyDBHelper  extends SQLiteOpenHelper {
    //database details
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Contactdb";
     // table details
    private static final String TABLE_CONTACTS = "Contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NUMBER = "PhoneNo";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CreateTable = "CREATE TABLE "+TABLE_CONTACTS+"("+KEY_ID +" INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT, "+KEY_PHONE_NUMBER+" TEXT)";
        db.execSQL(CreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
void addContact(Contacts contacts) {

    SQLiteDatabase db = this.getWritableDatabase();
    //create the content value object for the data to be inserted
    ContentValues values = new ContentValues();
    values.put(KEY_ID,contacts.getId());
    values.put(KEY_NAME,contacts.getName());
    values.put(KEY_PHONE_NUMBER,contacts.getPhoneNo());
    //insert the values into the table

    db.insert(TABLE_CONTACTS,null,values);
    //close the table
    Log.d("Test","Data saved");
    db.close();
    }
Contacts getContacts(int id)
{
    //get the readable database
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE_CONTACTS,new String[]{KEY_ID,KEY_NAME,KEY_PHONE_NUMBER},
            KEY_ID+"=?",new String[]{String.valueOf(id)},null,null,null);
    if(cursor!=null)
    {
        cursor.moveToFirst();
        int idTemp = cursor.getInt(0);
        String nameTemp = cursor.getString(1);
        String PhonenumberTemp = cursor.getString(2);
        Contacts c = new Contacts(idTemp,nameTemp,PhonenumberTemp);
        return c;
    }
    //if contact not found
    return null;
}
}
