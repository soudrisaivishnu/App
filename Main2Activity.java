package com.example.milagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyDBHelper dbHelper = new MyDBHelper(Main2Activity.this);


        TableLayout tableLayout = (TableLayout)findViewById(R.id.tablelayout);

        dbHelper.getRecords();
        Log.d("Test", String.valueOf(MyDBHelper.distance_id[13]));
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        TextView tv = (TextView)findViewById(R.id.tv);
        for(int i=0;i<10;i++) {
            String go ="  "+ MyDBHelper.distance_id[i] + "      " + MyDBHelper.petrol_id[i] + "        " + MyDBHelper.mileage_id[i];
            TextView tv1 = new TextView(Main2Activity.this);
            tv1.setText(go);
            tv1.setPadding(30,30,30,30);
            Log.d("Test",go);
            tv1.setText(go);
            linearLayout.addView(tv1);
        }
           }

}
