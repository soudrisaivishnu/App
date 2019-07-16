package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button btnset = (Button)findViewById(R.id.btnalarmset);
        btnset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText edseconds = (EditText)findViewById(R.id.edseconds);
                int seconds = Integer.parseInt(edseconds.getText().toString());

             //   Intent intent = new Intent(Main5Activity.this,MyReceiver.class);

             //   PendingIntent pendingIntent = PendingIntent.getBroadcast(Main5Activity.this,777,intent,0);





            }
        });
    }
}
