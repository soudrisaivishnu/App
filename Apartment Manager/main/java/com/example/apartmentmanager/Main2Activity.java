package com.example.apartmentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText edsuusername = (EditText)findViewById(R.id.edsuUsername);
        final EditText edsupassword = (EditText)findViewById(R.id.edsuPassword);
        final EditText edsuconfirmpassword = (EditText)findViewById(R.id.edsuConfirmpassword);
        final EditText edsuemailid = (EditText)findViewById(R.id.edsuEmailAddress);
        final EditText edsuaddress = (EditText)findViewById(R.id.edsuAddress);
        final EditText edsuphonenumber = (EditText)findViewById(R.id.edsuPhonenumber);

        Button btnsubmit = (Button)findViewById(R.id.btnSubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yes = edsupassword.getText().toString();
                String yes1 = edsuconfirmpassword.getText().toString();
                if(yes.equals(yes1))
                {
                    Log.d("Test","Matched");
                    String username = edsuusername.getText().toString();
                    String password = edsupassword.getText().toString();
                    String phoneNo = edsuphonenumber.getText().toString();
                    String emailid = edsuemailid.getText().toString();
                    String address = edsuaddress.getText().toString();

                    Details d = new Details(username,password,emailid,phoneNo,address);
                    DatabaseHelper databaseHelper =new DatabaseHelper(Main2Activity.this);
                    databaseHelper.addDetails(d);
                    Intent i = new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(i);

                }
                else
                    Toast.makeText(Main2Activity.this,"Confirm Password Must be same as Password",Toast.LENGTH_LONG).show();
//                Log.d("Test1",yes);
//                Log.d("Test2",yes1);
            }

        });

    }
}
