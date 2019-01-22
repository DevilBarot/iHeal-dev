package com.sismatix.iheal.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sismatix.iheal.R;

import static com.sismatix.iheal.Navigation_drawer_activity.appBarLayout;
import static com.sismatix.iheal.Navigation_drawer_activity.bottom_navigation;
import static com.sismatix.iheal.Navigation_drawer_activity.toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements View.OnClickListener {

    ImageView iv_home_haircare;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        bottom_navigation.setBackgroundColor(getResources().getColor(R.color.main));
        iv_home_haircare = (ImageView)v.findViewById(R.id.iv_home_haircare);

        bottom_navigation.setBackgroundColor(getResources().getColor(R.color.main));
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.main));
        toolbar.setBackgroundColor(getResources().getColor(R.color.main));

        iv_home_haircare.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_home_haircare:
                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rootLayout, new Haircare());
                fragmentTransaction.commit();
                break;

            default:
                break;
        }

    }
}
