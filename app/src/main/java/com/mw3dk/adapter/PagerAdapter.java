package com.mw3dk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mw3dk.fragments.ProfessionalFragment;

/**
 * Created by snyxius on 5/5/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new ProfessionalFragment();
                break;
            case 1:
                frag=new ProfessionalFragment();
                break;
//            case 2:
//                frag=new StudyFragment();
//                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Profile";
                break;
            case 1:
                title="Reviews";
                break;
//            case 2:
//                title="Study";
//                break;
        }

        return title;
    }
}