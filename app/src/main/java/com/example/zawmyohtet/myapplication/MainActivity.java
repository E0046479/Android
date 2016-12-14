package com.example.zawmyohtet.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import static android.R.attr.data;
import static com.example.zawmyohtet.myapplication.R.styleable.MenuItem;

public class MainActivity extends AppCompatActivity {
    CheckBox checkbox1;
    EditText text;

    void append(String m) {
        text.append(m + "\n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
        text = (EditText) findViewById(R.id.editText1);
        // make anonymous object as listener
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                append("button Clicked");
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        // make activity as listener
       // checkbox1.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                append("item1");
                return true;
            case R.id.item2:
                append("item2");
                return true;
            case R.id.item3:
                append("item3");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//    @Override
//    public void onClick(View v) {
//        append("checkbox changed");
//    }
@Override
public void onCreateContextMenu(ContextMenu menu, View v,
                                ContextMenu.ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.context, menu);
}

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                // do something
                return true;
            case R.id.item2:
                // for ListView, can do following for index to data
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int index = (int) info.id;
                Model m = data[index];
                // do something with m
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
