package com.example.apartmentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnlogin = (Button)findViewById(R.id.btnLogin);
        Button btnsignup = (Button)findViewById(R.id.btnSignup);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(t);
            }
        });
    btnlogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        EditText edpassword = (EditText)findViewById(R.id.edPassword);
        EditText edussername = (EditText)findViewById(R.id.edUsername);
        String username1 = edussername.getText().toString();
        String password1 = edpassword.getText().toString();
        Details d = db.getDetails(username1);
        Log.d("Test3",d.getPassword());

        String a = d.getPassword();
        if(a.equals(password1))
        {
            Toast.makeText(MainActivity.this,"Password Matched",Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(i);
        }

        }
    });
    }
}
