package com.example.dynamictable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
EditText Rows ;
EditText Columns;
Button Create;
Button View1;
TableLayout Create1;
TableLayout View2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Create = (Button) findViewById(R.id.btncreate);
     Create.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             Rows = (EditText) findViewById(R.id.edRows);
             Columns = (EditText) findViewById(R.id.edColumns);
             int row = Integer.parseInt(Rows.getText().toString());
             int column = Integer.parseInt(Columns.getText().toString());
             Create1 = (TableLayout) findViewById(R.id.tablelayout1);
             View2 = (TableLayout) findViewById(R.id.tablelayout2);
             for (int i = 0; i < row; i++) {
                 TableRow rows = new TableRow(MainActivity.this);

                 for (int j = 0; j < column; j++) {
                     EditText et = new EditText(MainActivity.this);
                     et.setText("c" + i + j);
                     rows.addView(et);
                 }
                 Create1.addView(rows);
             }
         }
     });



    }
}
