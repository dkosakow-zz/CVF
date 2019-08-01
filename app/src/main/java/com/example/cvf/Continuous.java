package com.example.cvf;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.ArrayList;
import java.util.Objects;

public class Continuous extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuous);
        //Toolbar
        Toolbar toolbar = findViewById(R.id.continuousToolbar);     //Instantiate toolbar
        toolbar.setTitle("Continuous");                             //Title
        toolbar.setSubtitle("Unidirectional Continuous Fiber");     //Subtitle
        setSupportActionBar(toolbar);                               //Make the custom toolbar the app's actionbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        //TabLayout Setup
        tabLayout = (TabLayout) findViewById(R.id.continuousTablayout);
        appBarLayout = (AppBarLayout) findViewById(R.id.continuousAppbarlayout);
        viewPager = (ViewPager) findViewById(R.id.continuousViewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentContinuousMaterial(), "Material Definitions");
        adapter.AddFragment(new FragmentContinuousProperties(), "Homogeneous Properties");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //TODO
    }   //onCreate(Bundle)

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
                //startActivity(new Intent(Continuous.this, -------.class));
                break;
            case R.id.otherMaterialmanager:
                startActivity(new Intent(getApplicationContext(), MaterialManager.class));
                break;
        }   //switch (item.getItemId())
        return super.onOptionsItemSelected(item);
    }   //onOptionsItemSelected(MenuItem)

    public static class FragmentContinuousMaterial extends Fragment {
        public FragmentContinuousMaterial() {}
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Spinner materialSpinner1 = (Spinner) getView().findViewById(R.id.continuousMaterialSpinnerMaterial);
            ArrayList<String> materialList1 = new ArrayList<>();
            for (Material object : Library.materials) {
                if (object.getFiberType() == Material.FiberType.FIBER) {
                    materialList1.add(object.getName());
                }   //if FiberType is FIBER
            }   //add Fibers to spinner
            ArrayAdapter<String> adapterSpinner1 = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, materialList1) {
                @NonNull
                public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                    View v = super.getView(position, convertView, parent);
                    TextView tv = ((TextView) v);
                    tv.setTextColor(getResources().getColor(R.color.text));
                    tv.setTypeface(tv.getTypeface(), Typeface.NORMAL);
                    tv.setSingleLine();
                    tv.setEllipsize(TextUtils.TruncateAt.END);
                    tv.setTextSize(18);
                    tv.setGravity(Gravity.CENTER);
                    return v;
                }
            };
            adapterSpinner1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            materialSpinner1.setAdapter(adapterSpinner1);
            Spinner materialSpinner2 = (Spinner) getView().findViewById(R.id.continuousMaterialSpinnerMaterial2);
            ArrayList<String> materialList2 = new ArrayList<>();
            for (Material object : Library.materials) {
                if (object.getFiberType() == Material.FiberType.MATRIX) {
                    materialList2.add(object.getName());
                } //if FiberType is MATRIX
            }   //add Matrix materials to spinner
            ArrayAdapter<String> adapterSpinner2 = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, materialList2) {
                @NonNull
                public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                    View v = super.getView(position, convertView, parent);
                    TextView tv = ((TextView) v);
                    tv.setTextColor(getResources().getColor(R.color.text));
                    tv.setTypeface(tv.getTypeface(), Typeface.NORMAL);
                    tv.setSingleLine();
                    tv.setEllipsize(TextUtils.TruncateAt.END);
                    tv.setTextSize(18);
                    tv.setGravity(Gravity.CENTER);
                    return v;
                }
            };
            adapterSpinner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            materialSpinner2.setAdapter(adapterSpinner2);
        }   //onActivityCreated
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_continuous_material, container, false);
            final ToggleButton toggleButtonFiberContent = (ToggleButton) v.findViewById(R.id.continuousMaterialToggleFibercontent);
            final TextView textViewFiberFraction = (TextView) v.findViewById(R.id.continuousMaterialTextviewFraction);
            toggleButtonFiberContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (toggleButtonFiberContent != null && toggleButtonFiberContent.isChecked()) {
                        textViewFiberFraction.setText(R.string.fiber_weight_fraction);
                    } else if (toggleButtonFiberContent != null) {
                        textViewFiberFraction.setText(R.string.fiber_volume_fraction);
                    }   //if-else(toggleButtonFiberContent isn't null and is checked)
                }   //onClick(View)
            }); //setOnClickListener

            //Text
            TextView fiberContent = (TextView) v.findViewById(R.id.continuousMaterialTextviewFibercontent);
            final EditText density = (EditText) v.findViewById(R.id.continuousMaterialTexteditDensity);
            density.setEnabled(false);
            return v;
        }   //onCreateView
    }   //Fragment Continuous Material

    public static class FragmentContinuousProperties extends Fragment {
        public FragmentContinuousProperties() {}
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_continuous_properties, container, false) ;
        }   //onCreateView
    }   //Fragment Continuous Properties
}   //Continuous
