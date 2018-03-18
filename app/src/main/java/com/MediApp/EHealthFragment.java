package com.MediApp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EHealthFragment extends Fragment {

    public View mMainView;

    private Button details,profile;
    public EHealthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mMainView=inflater.inflate(R.layout.fragment_ehealth, container, false);
        details=(Button)mMainView.findViewById(R.id.currenthealth_btn);
        profile=(Button)mMainView.findViewById(R.id.settings_status_btn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent=new Intent(getContext(),Signup.class);
                startActivity(setupIntent);
            }
        });
    return mMainView;
    }


}
