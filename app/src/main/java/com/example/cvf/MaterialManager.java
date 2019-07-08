package com.example.cvf;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MaterialManager extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_manager);

        //Make Popup Style
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout((int) (0.8 * displayMetrics.widthPixels), (int) (0.8 * displayMetrics.heightPixels));

        //Layout initialization
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.materialConstraintlayout);

        //Material Spinner
        final Spinner materialSpinner = (Spinner) findViewById(R.id.materialSpinner1);

        ArrayList<String> materialList = new ArrayList<>();
        for (Material object : MaterialLibrary.materials) {
            materialList.add(object.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, materialList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        materialSpinner.setAdapter(adapter);

        //Text
        final TextView materialName = (TextView) findViewById(R.id.materialTextviewName);
        materialName.setEnabled(false);

    }   //onCreate(Bundle)
}   //MaterialManager
