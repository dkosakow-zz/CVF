package com.example.cvf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import static com.example.cvf.MaterialLibrary.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);   //Instantiate toolbar
        toolbar.setTitle("CVF Material");                             //Title
        setSupportActionBar(toolbar);                                 //Make the custom toolbar the app's actionbar

        //Home Screen (Main Menu)
        Button button1 = findViewById(R.id.mainButtonContinuous);     //Button Selection "Continuous"
        button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, Continuous.class));
           }    //onClick(View)
        });

        Button button2 = findViewById(R.id.mainButtonSfrp);     //Button Selection "SFRP"
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SFRP.class));
            }    //onClick(View)
        });

        Button button3 = findViewById(R.id.mainButtonLaminate);     //Button Selection "Laminate"
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Laminate.class));
            }    //onClick(View)
        });
    }   //onCreate(Bundle)

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_other, menu);
        return true;
    }   //onCreateOptionsMenu(Menu)

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.otherClear:
                //TODO
                break;
            case R.id.otherSettings:
                //TODO
                break;
            case R.id.otherMaterialmanager:
                startActivity(new Intent(MainActivity.this, MaterialManager.class));
                break;
        }   //switch (item.getItemId())
        return super.onOptionsItemSelected(item);
    }   //onOptionsItemSelected(MenuItem)
}   //MainActivity