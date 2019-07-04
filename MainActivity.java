package com.example.milagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float distance2;
    float petrol2;
    float mileage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculate = (Button)findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    EditText distance1 = (EditText) findViewById(R.id.edDistance);

                    EditText petrol1 = (EditText) findViewById(R.id.edPetrol);
                    float distance = Float.parseFloat(distance1.getText().toString());
                    float petrol = Float.parseFloat(petrol1.getText().toString());
                    float milage = distance / petrol;
                    TextView milage1 = (TextView) findViewById(R.id.tvMilage);

                    milage1.setText("Mileage is " + milage);
                    milage1.setTextSize(18);
                    mileage2=milage;
                    distance2 = distance;
                    petrol2 = petrol;
                }
            catch (java.lang.NumberFormatException e)
               {
                   Toast.makeText(MainActivity.this,"Enter the values",Toast.LENGTH_LONG).show();
               }
            }
        });
        Button submit = (Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper dbHelper = new MyDBHelper(MainActivity.this);
                Records r = new Records(distance2,petrol2,mileage2);
                dbHelper.addRecords(r);
                Toast.makeText(MainActivity.this,"Data Added",Toast.LENGTH_LONG).show();
            }
        });
        Button history = (Button)findViewById(R.id.btnHistory);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
