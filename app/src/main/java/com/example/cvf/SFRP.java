package com.example.cvf;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Objects;

public class SFRP extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfrp);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.sfrpToolbar);   //Instantiate toolbar
        toolbar.setTitle("SFRP");                           //Title
        toolbar.setSubtitle("Discontinuous Fiber");         //Subtitle
        setSupportActionBar(toolbar);                       //Make the custom toolbar the app's actionbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //TabLayout Setup
        tabLayout = (TabLayout) findViewById(R.id.sfrpTablayout);
        appBarLayout = (AppBarLayout) findViewById(R.id.sfrpAppbarlayout);
        viewPager = (ViewPager) findViewById(R.id.sfrpViewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentSFRPMaterial(), "Material Definitions");
        adapter.AddFragment(new FragmentSFRPProperties(), "Homogeneous Properties");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

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

                break;
            case R.id.otherSettings:
                //TODO
                break;
            case R.id.otherMaterialmanager:
                startActivity(new Intent(SFRP.this, MaterialManager.class));
                break;
        }   //switch (item.getItemId())
        return super.onOptionsItemSelected(item);
    }   //onOptionsItemSelected(MenuItem)

    public static class FragmentSFRPMaterial extends Fragment {
        public FragmentSFRPMaterial() {}
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_sfrp_material, container, false);
            TextView textViewFiberContent = (TextView) v.findViewById(R.id.sfrpMaterialTextviewFibercontent);
            final ToggleButton toggleButtonFiberContent = (ToggleButton) v.findViewById(R.id.sfrpMaterialToggleFibercontent);
            final TextView textViewFiberFraction = (TextView) v.findViewById(R.id.sfrpMaterialTextviewFiberfraction);
            toggleButtonFiberContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (toggleButtonFiberContent != null && toggleButtonFiberContent.isChecked()) {
                        textViewFiberFraction.setText(R.string.fiber_weight_fraction);
                    } else if (toggleButtonFiberContent != null) {
                        textViewFiberFraction.setText(R.string.fiber_volume_fraction);
                    }   //if-else(toggleButton isChecked)
                }   //onClick
            });

            final TextView textViewFillerFraction = (TextView) v.findViewById(R.id.sfrpMaterialTextviewFillerfraction);
            final ToggleButton toggleButtonFillerContent = (ToggleButton) v.findViewById(R.id.sfrpMaterialToggleFillercontent);
            toggleButtonFillerContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (toggleButtonFillerContent != null && toggleButtonFillerContent.isChecked()) {
                        textViewFillerFraction.setText(R.string.filler_weight_fraction);
                    } else if (toggleButtonFillerContent != null) {
                        textViewFillerFraction.setText(R.string.filler_volume_fraction);
                    }   //if-else(toggleButton isChecked)
                }   //onClick
            });

            final TextView orientation11 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix11);
            final TextView orientation12 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix12);
            final TextView orientation13 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix13);
            final TextView orientation21 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix21);
            final TextView orientation22 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix22);
            final TextView orientation23 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix23);
            final TextView orientation31 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix31);
            final TextView orientation32 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix32);
            final TextView orientation33 = (TextView) v.findViewById(R.id.sfrpMaterialTextviewMatrix33);

            final EditText fiberFraction = (EditText) v.findViewById(R.id.sfrpMaterialTexteditFiberfraction);
            final EditText fillerFraction = (EditText) v.findViewById(R.id.sfrpMaterialTexteditFillerfraction);

            return v;
        }   //onCreateView()
    }   //Fragment SFRP Material

    public static class FragmentSFRPProperties extends Fragment {
        public FragmentSFRPProperties() {}
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_sfrp_properties, container, false);
        }   //onCreateView
    }   //Fragment SFRP Properties
}   //SFRP
