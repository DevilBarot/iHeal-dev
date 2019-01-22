package com.sismatix.iheal.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.sismatix.iheal.R;

import static com.sismatix.iheal.Navigation_drawer_activity.appBarLayout;
import static com.sismatix.iheal.Navigation_drawer_activity.bottom_navigation;
import static com.sismatix.iheal.Navigation_drawer_activity.toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Haircare extends Fragment {

    Button btn_haircare_ex_prod;


    public Haircare() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_haircare, container, false);
        getActivity().setTheme(android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getActivity().getResources().getColor(R.color.trans));
            /*getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.trans));*/
        }

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getActivity().getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/

        bottom_navigation.setBackgroundColor(getResources().getColor(R.color.trans));
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.trans));
        toolbar.setBackgroundColor(getResources().getColor(R.color.trans));

        btn_haircare_ex_prod = (Button)v.findViewById(R.id.btn_haircare_ex_prod);

        btn_haircare_ex_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rootLayout, new Itemlist());
                fragmentTransaction.commit();

            }
        });

        //bottom_navigation.getBackground().setAlpha(122);
        //bottom_navigation.getBackground().setColorFilter(0x80ffffff, PorterDuff.Mode.MULTIPLY);
        //bottom_navigation.setBackgroundColor(Color.GRAY);

        return v;

    }


}
