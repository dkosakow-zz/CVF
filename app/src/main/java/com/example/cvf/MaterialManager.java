package com.example.cvf;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MaterialManager extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    Material currentMaterial;
    String currentItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_manager);
        //Toolbar
        Toolbar toolbar = findViewById(R.id.materialToolbar);       //Instantiate toolbar
        toolbar.setTitle("Material Manager");                       //Title
        toolbar.setSubtitle("View and Edit Materials");             //Subtitle
        setSupportActionBar(toolbar);                               //Make the custom toolbar the app's actionbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        //<editor-fold desc="Initialization">
        //Layout initialization
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.materialConstraintlayout);
        //Property Text Fields
        final TextView textviewE1 = (TextView) findViewById(R.id.materialTextviewE1);
        final TextView textviewE2 = (TextView) findViewById(R.id.materialTextviewE2);
        final TextView textviewG12 = (TextView) findViewById(R.id.materialTextviewG12);
        final TextView textviewV12 = (TextView) findViewById(R.id.materialTextviewV12);
        final TextView textviewV23 = (TextView) findViewById(R.id.materialTextviewV23);
        final TextView textviewA1 = (TextView) findViewById(R.id.materialTextviewA1);
        final TextView textviewA2 = (TextView) findViewById(R.id.materialTextviewA2);
        final TextView textviewDensity = (TextView) findViewById(R.id.materialTextviewDensity);
        //Text
        final EditText materialName = (EditText) findViewById(R.id.materialTexteditName);
        //Data TextEdit Fields
        final EditText texteditE1data = (EditText) findViewById(R.id.materialTexteditE1data);
        final EditText texteditE2data = (EditText) findViewById(R.id.materialTexteditE2data);
        final EditText texteditG12data = (EditText) findViewById(R.id.materialTexteditG12data);
        final EditText texteditV12data = (EditText) findViewById(R.id.materialTexteditV12data);
        final EditText texteditV23data = (EditText) findViewById(R.id.materialTexteditV23data);
        final EditText texteditA1data = (EditText) findViewById(R.id.materialTexteditA1data);
        final EditText texteditA2data = (EditText) findViewById(R.id.materialTexteditA2data);
        final EditText texteditDensitydata = (EditText) findViewById(R.id.materialTexteditDensitydata);
        final TextView textviewE1data = (TextView) findViewById(R.id.materialTextviewE1data);
        final TextView textviewE2data = (TextView) findViewById(R.id.materialTextviewE2data);
        final TextView textviewG12data = (TextView) findViewById(R.id.materialTextviewG12data);
        final TextView textviewV12data = (TextView) findViewById(R.id.materialTextviewV12data);
        final TextView textviewV23data = (TextView) findViewById(R.id.materialTextviewV23data);
        final TextView textviewA1data = (TextView) findViewById(R.id.materialTextviewA1data);
        final TextView textviewA2data = (TextView) findViewById(R.id.materialTextviewA2data);
        final TextView textviewDensitydata = (TextView) findViewById(R.id.materialTextviewDensitydata);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.materialRadiogroup);
        final RadioButton radiobuttonFiber = (RadioButton) findViewById(R.id.materialRadiobuttonFiber);
        final RadioButton radiobuttonMatrix = (RadioButton) findViewById(R.id.materialRadiobuttonMatrix);
        final RadioButton radiobuttonFiller = (RadioButton) findViewById(R.id.materialRadiobuttonFiller);
        //</editor-fold>

        //Material Spinner
        final Spinner materialSpinner = (Spinner) findViewById(R.id.materialSpinner1);
        ArrayList<String> materialList = new ArrayList<>();
        for (Material object : Library.materials) {
            materialList.add(object.getName());
        }   //for each material
        //Updater
        class Updater {

            void AllowEdit() {
                materialName.setClickable(true); materialName.setEnabled(true);
                radiobuttonFiber.setClickable(true); radiobuttonFiber.setEnabled(true);
                radiobuttonMatrix.setClickable(true); radiobuttonMatrix.setEnabled(true);
                radiobuttonFiller.setClickable(true); radiobuttonFiller.setEnabled(true);
                textviewE1data.setVisibility(View.INVISIBLE); textviewE2data.setVisibility(View.INVISIBLE);
                textviewV12data.setVisibility(View.INVISIBLE); textviewV23data.setVisibility(View.INVISIBLE);
                textviewG12data.setVisibility(View.INVISIBLE); textviewDensitydata.setVisibility(View.INVISIBLE);
                textviewA1data.setVisibility(View.INVISIBLE); textviewA2data.setVisibility(View.INVISIBLE);
                texteditE1data.setVisibility(View.VISIBLE); texteditE2data.setVisibility(View.VISIBLE);
                texteditV12data.setVisibility(View.VISIBLE); texteditV23data.setVisibility(View.VISIBLE);
                texteditG12data.setVisibility(View.VISIBLE); texteditDensitydata.setVisibility(View.VISIBLE);
                texteditA1data.setVisibility(View.VISIBLE); texteditA2data.setVisibility(View.VISIBLE);
            }   //AllowEdit()

            void DisallowEdit() {
                materialName.setClickable(false); materialName.setEnabled(false);
                radiobuttonFiber.setClickable(false); radiobuttonFiber.setEnabled(false);
                radiobuttonMatrix.setClickable(false); radiobuttonMatrix.setEnabled(false);
                radiobuttonFiller.setClickable(false); radiobuttonFiller.setEnabled(false);
                textviewE1data.setVisibility(View.VISIBLE); textviewE2data.setVisibility(View.VISIBLE);
                textviewV12data.setVisibility(View.VISIBLE); textviewV23data.setVisibility(View.VISIBLE);
                textviewG12data.setVisibility(View.VISIBLE); textviewDensitydata.setVisibility(View.VISIBLE);
                textviewA1data.setVisibility(View.VISIBLE); textviewA2data.setVisibility(View.VISIBLE);
                texteditE1data.setVisibility(View.INVISIBLE); texteditE2data.setVisibility(View.INVISIBLE);
                texteditV12data.setVisibility(View.INVISIBLE); texteditV23data.setVisibility(View.INVISIBLE);
                texteditG12data.setVisibility(View.INVISIBLE); texteditDensitydata.setVisibility(View.INVISIBLE);
                texteditA1data.setVisibility(View.INVISIBLE); texteditA2data.setVisibility(View.INVISIBLE);
            }

            void UpdateText(Material currentMaterial) {
                getCurrentMaterial();
                texteditE1data.setText(String.format("%f", currentMaterial.getYoungsModulus1()));
                texteditE2data.setText(Double.toString(currentMaterial.getYoungsModulus2()));
                texteditG12data.setText(Double.toString(currentMaterial.getShearModulus12()));
                texteditV12data.setText(Double.toString(currentMaterial.getPoissonsRatio12()));
                texteditV23data.setText(Double.toString(currentMaterial.getPoissonsRatio23()));
                texteditA1data.setText(Double.toString(currentMaterial.getThermalExpansion1()));
                texteditA2data.setText(Double.toString(currentMaterial.getThermalExpansion2()));
                texteditDensitydata.setText(Double.toString(currentMaterial.getDensity()));
                textviewE1data.setText(Double.toString(currentMaterial.getYoungsModulus1()));
                textviewE2data.setText(Double.toString(currentMaterial.getYoungsModulus2()));
                textviewG12data.setText(Double.toString(currentMaterial.getShearModulus12()));
                textviewV12data.setText(Double.toString(currentMaterial.getPoissonsRatio12()));
                textviewV23data.setText(Double.toString(currentMaterial.getPoissonsRatio23()));
                textviewA1data.setText(Double.toString(currentMaterial.getThermalExpansion1()));
                textviewA2data.setText(Double.toString(currentMaterial.getThermalExpansion2()));
                textviewDensitydata.setText(Double.toString(currentMaterial.getDensity()));
                materialName.setText(currentMaterial.getName());
                switch (currentMaterial.getFiberType()) {
                    case FIBER:
                        radiobuttonFiber.toggle();
                        break;
                    case FILLER:
                        radiobuttonFiller.toggle();
                        break;
                    case MATRIX:
                        radiobuttonMatrix.toggle();
                        break;
                }   //switch (FiberType)
            }   //UpdateText(Material)

            private void getCurrentMaterial() {
                for (int i = 0; i < Library.materials.size(); i++) {
                    if (Library.materials.get(i).getName().equals(currentItem)) {
                        currentMaterial = Library.materials.get(i);
                        break;
                    }
                }   //set the current material
            }   //Get Current Material

        }   //Updater
        final Updater updater = new Updater();
        currentMaterial = Library.materials.get(0);
        updater.getCurrentMaterial(); updater.DisallowEdit(); updater.UpdateText(currentMaterial);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, materialList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        materialSpinner.setAdapter(adapter);
        currentItem = materialSpinner.getSelectedItem().toString();
        materialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                currentItem = materialSpinner.getSelectedItem().toString();
                updater.getCurrentMaterial();
                updater.UpdateText(currentMaterial);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //Leave blank
            }
        });
        //Radio Buttons
        radiobuttonFiber.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (radiobuttonFiber.isChecked()) {
                    currentMaterial.setFiberType(Material.FiberType.FIBER);
                }
            }   //onClick(View)
        });
        radiobuttonFiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiobuttonFiller.isChecked()) {
                    currentMaterial.setFiberType(Material.FiberType.FILLER);
                }
            }
        });
        radiobuttonMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiobuttonMatrix.isChecked()) {
                    currentMaterial.setFiberType(Material.FiberType.MATRIX);
                }
            }
        });
        //<editor-fold desc="Allow Edit">
        //Allow Edit
        new Updater().DisallowEdit();
        final Switch switchAllowedit = (Switch) findViewById(R.id.materialSwitchEdit);
        switchAllowedit.setChecked(false);
        switchAllowedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchAllowedit.isChecked()) {
                    new Updater().AllowEdit();
                } else {
                    new Updater().DisallowEdit();
                }   //if the switch is already toggled
            }   //onClick(View)
        });
        //</editor-fold>
    }   //onCreate(Bundle)
}   //MaterialManager