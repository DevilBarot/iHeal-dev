package com.sismatix.iheal.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sismatix.iheal.R;

import static com.sismatix.iheal.Navigation_drawer_activity.appBarLayout;
import static com.sismatix.iheal.Navigation_drawer_activity.bottom_navigation;
import static com.sismatix.iheal.Navigation_drawer_activity.toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {

    LinearLayout lv_email_singup;
    TextView tv_login;

    public Account() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_account, container, false);

        lv_email_singup = (LinearLayout)v.findViewById(R.id.lv_email_singup);
        tv_login = (TextView)v.findViewById(R.id.tv_login);

        bottom_navigation.setBackgroundColor(getResources().getColor(R.color.main));
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.main));
        toolbar.setBackgroundColor(getResources().getColor(R.color.main));

        lv_email_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Signup nextFrag= new Signup();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.rootLayout, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailLogin nextFrag= new EmailLogin();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.rootLayout, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        return v;

    }

}
