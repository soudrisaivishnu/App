package com.example.milagecalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import java.lang.reflect.Array;

public class MyDBHelper extends SQLiteOpenHelper {
    public static float[] distance_id = new float[15];
    public static float[] petrol_id = new float[15];
    public static float[] mileage_id = new float[15];
    //database details
    private static final String DATABASE_NAME = "RecordsDB";
    private static final int DATABASE_VERSION= 1;
    //table details
    private static final String TABLE_NAME = "Records";
   // private static final String ID = "Id";
    private static final String DISTANCE_ID = "Distance";
    private static final String PETROL_ID = "Petrol";
    private static final String MILAGE_ID = "Milage";


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createRecords = "CREATE TABLE "+ TABLE_NAME+"( "+DISTANCE_ID+" FLOAT, "+PETROL_ID+" FLOAT, "+MILAGE_ID+" FLOAT)";
        db.execSQL(createRecords);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  void addRecords(Records records)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

       // values.put(ID,records.getId());
        values.put(DISTANCE_ID,records.getDistance());
        values.put(PETROL_ID,records.getPetrol());
        values.put(MILAGE_ID,records.getMilage());
        db.insert(TABLE_NAME,null,values);
        db.close();

    }

//    Records getRecords() {
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//
//        cursor.moveToFirst();
//        for(int i=0;i<cursor.getCount();i++)
//        {
//
//
//            float distance_id = cursor.getFloat(0);
//            float petrol_id = cursor.getFloat(1);
//            float milage_id = cursor.getFloat(2);
//            Records c = new Records(distance_id,petrol_id,milage_id);
//            Log.d("Test", String.valueOf(distance_id+" "+ petrol_id+" "+ milage_id));
//            return c;
//
//    }
//        //if contact not found
//        return null;
//    }
    public void getRecords()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        cursor.moveToFirst();
        for(int i=0;i< cursor.getCount();i++)
        {
           float  distance_id1 = cursor.getFloat(0);
           float   petrol_id1 = cursor.getFloat(1);
           float   mileage_id1 = cursor.getFloat(2);
            Records c = new Records(distance_id1,petrol_id1,mileage_id1);
            Log.d("Test", distance_id1+" "+ petrol_id1+" "+ mileage_id1);

            distance_id[i] = distance_id1;
            petrol_id[i] = petrol_id1;
            mileage_id[i] = mileage_id1;
            Log.d("TestA", String.valueOf(distance_id[i]));

            cursor.moveToNext();

        }



    }
}

