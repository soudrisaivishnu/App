package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
final int REQUEST_CAMERA_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,REQUEST_CAMERA_CODE);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        if(requestCode == REQUEST_CAMERA_CODE && resultCode == RESULT_OK)
        {
            Bundle bundle = data.getExtras();
            Bitmap mybit = (Bitmap) bundle.get("data");
            ImageView img = (ImageView)findViewById(R.id.imageView2);
            img.setImageBitmap(mybit);
        }
    }
}
