package com.sismatix.iheal.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sismatix.iheal.R;

import static com.sismatix.iheal.Navigation_drawer_activity.appBarLayout;
import static com.sismatix.iheal.Navigation_drawer_activity.bottom_navigation;
import static com.sismatix.iheal.Navigation_drawer_activity.toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Favourite extends Fragment {


    public Favourite() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favourite, container, false);

        bottom_navigation.setBackgroundColor(getResources().getColor(R.color.main));
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.main));
        toolbar.setBackgroundColor(getResources().getColor(R.color.main));

        return v;
    }

}
