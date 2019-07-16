package com.example.databasetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  String key_user_name = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences prefs = getSharedPreferences("login_data",MODE_PRIVATE);
//        String user = prefs.getString(key_user_name,"Default User");
//        String welcomeMessage = "Welcome " + user;
//
//        TextView tv = (TextView)findViewById(R.id.textView2);
//        tv.setText(welcomeMessage);
//        final EditText etMessage = (EditText)findViewById(R.id.editText);
//        Button btn = (Button)findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = etMessage.getText().toString();
//                SharedPreferences prefs = MainActivity.this.getSharedPreferences("login_data",MODE_PRIVATE);
//                SharedPreferences.Editor editor = prefs.edit();
//                editor.putString(key_user_name,user);
//                editor.commit();
//            }
//        });
                final EditText etid = (EditText) findViewById(R.id.edId);
                final EditText etname = (EditText)findViewById(R.id.edName);
                final EditText etphoneNo = (EditText) findViewById(R.id.edPhonenumber);
                Button save = (Button)findViewById(R.id.btnSave);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int id = Integer.parseInt(etid.getText().toString());
                        String name = etname.getText().toString();
                        String phoneNo = etphoneNo.getText().toString();

                        Contacts c = new Contacts(id,name,phoneNo);
                        MyDBHelper myDBhelper = new MyDBHelper(MainActivity.this);
                        myDBhelper.addContact(c);


                    }
                });
                Button btnload = (Button)findViewById(R.id.btnload);
                btnload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MyDBHelper myDBhelper = new MyDBHelper(MainActivity.this);
                        Contacts d = myDBhelper.getContacts(2);
                        String data = "ID: "+ d.getId() + "\nName: "+d.getName()+"\nPhone Number: "+d.getPhoneNo();
                        Toast.makeText(MainActivity.this,data,Toast.LENGTH_LONG).show();
                    }
                });

                Button btnnext = (Button)findViewById(R.id.next);
                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(i);
                    }
                });


    }
}
