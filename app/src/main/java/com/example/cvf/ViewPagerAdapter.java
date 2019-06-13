package com.example.cvf;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentListTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }   //ViewPagerAdapter(FragmentManager fm)

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }   //getItem(int)

    @Override
    public int getCount() {
        return fragmentList.size();
    }   //getCount()

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }   //getPageTitle(int)

    public void AddFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentListTitles.add(title);
    }
}