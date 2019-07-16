package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Countries));
        ListView lv = (ListView)findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListView listView = (ListView)adapterView;
                Toast.makeText(Main4Activity.this, (String)listView.getItemAtPosition(i), Toast.LENGTH_LONG).show();
            }
        });

        Button play = (Button)findViewById(R.id.btnPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, Settings.System.DEFAULT_RINGTONE_URI);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
        });


    }
}
