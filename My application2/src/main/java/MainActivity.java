package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    final int REQUEST_CAMERA_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      Button btn = (Button)findViewById(R.id.btnNext);
      btn.setOnClickListener(new View.OnClickListener()
      {
          @Override
          public void onClick(View v)
          {

          //  Intent j = new Intent(MainActivity.this,Main4Activity.class);
          //Intent i = new Intent("android.demo.ACTION");
              Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();
           //   startActivity(j);
             // Intent i = new Intent();
             // i.setAction(Intent.ACTION_SEND);
             // i.putExtra(Intent.EXTRA_TEXT,message);
              //i.setType("Text/plain");
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
              startActivity(i);
              // to start camera


          }
      });
Button btnclose = (Button)findViewById(R.id.btnExit);
btnclose.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
});
//      Button simpleButton1 = (Button) findViewById(R.id.button);
//        simpleButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();//display the text of button1
//            }
//        });
    }


}