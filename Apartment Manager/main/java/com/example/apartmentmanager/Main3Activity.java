package com.example.apartmentmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String[] list = {"About Apartment","Amenities","Association"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main3Activity.this,android.R.layout.simple_list_item_1,list);

        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListView listView = (ListView)adapterView;
                Toast.makeText(Main3Activity.this, "ListView", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
