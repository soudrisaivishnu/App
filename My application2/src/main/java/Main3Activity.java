package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] name =  {"Android","Java","C","C++","Angular","Python"};
    String[] data = {"Android","Java","C","C++","Angular","Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,data);
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        actv.setAdapter(adapter2);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,name);
        spinner.setAdapter(adapter);



}


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast t = Toast.makeText(this, name[i], Toast.LENGTH_LONG);
        t.show();
        if (i == 2) {
             Intent j = new Intent(this,MainActivity.class);
              startActivity(j);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
