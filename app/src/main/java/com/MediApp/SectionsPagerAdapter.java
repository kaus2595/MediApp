package com.MediApp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Honey Sharma.
 */

class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                EHealthFragment eHealthFragment = new EHealthFragment();
                return eHealthFragment;

            case 1:
                AppointmentFragment appointmentFragment = new AppointmentFragment();

                return appointmentFragment;

            case 2:
                MedicinesFragment medicinesFragment = new MedicinesFragment();

                return medicinesFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "E-Health";

            case 1:
                return "Appointement";

            case 2:
                return "Medicines";

            default:
                return null;
        }
    }
}