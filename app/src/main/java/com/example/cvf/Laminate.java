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

import java.util.Objects;

public class Laminate extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laminate);

        Toolbar toolbar = findViewById(R.id.laminateToolbar);   //Instantiate toolbar
        toolbar.setTitle("Laminate");                           //Title
        toolbar.setSubtitle("Laminate Definition");             //Subtitle
        setSupportActionBar(toolbar);                           //Make the custom toolbar the app's actionbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //TabLayout Setup
        tabLayout = (TabLayout) findViewById(R.id.laminateTablayout);
        appBarLayout = (AppBarLayout) findViewById(R.id.laminateAppbarlayout);
        viewPager = (ViewPager) findViewById(R.id.laminateViewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentLaminateStacking(), "Stacking\nSequence");
        adapter.AddFragment(new FragmentLaminateMaterial(), "Material\nDefinition");
        adapter.AddFragment(new FragmentLaminateProperties(), "Properties");
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
                //TODO
                break;
            case R.id.otherSettings:
                //TODO
                break;
            case R.id.otherMaterialmanager:
                startActivity(new Intent(Laminate.this, MaterialManager.class));
                break;
        }   //switch (item.getItemId())
        return super.onOptionsItemSelected(item);
    }   //onOptionsItemSelected(MenuItem)

    public static class FragmentLaminateMaterial extends Fragment {
        public FragmentLaminateMaterial() {}
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_laminate_material, container, false);
        }   //onCreateView
    }   //Fragment Laminate Material

    public static class FragmentLaminateStacking extends Fragment {
        public FragmentLaminateStacking() {}
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_laminate_stacking, container, false);
        }   //onCreateView
    }   //Fragment Laminate Material

    public static class FragmentLaminateProperties extends Fragment {
        public FragmentLaminateProperties() {}
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_laminate_properties, container, false);
        }   //onCreateView
    }   //Fragment Laminate Material
}   //Laminate
