package com.sismatix.iheal.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sismatix.iheal.R;

import static com.sismatix.iheal.Navigation_drawer_activity.appBarLayout;
import static com.sismatix.iheal.Navigation_drawer_activity.bottom_navigation;
import static com.sismatix.iheal.Navigation_drawer_activity.toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cart extends Fragment {
    int minteger = 0;
    TextView tv_total;
    ImageView iv_increase,decrease;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_cart, container, false);

        bottom_navigation.setBackgroundColor(getResources().getColor(R.color.main));
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.main));
        toolbar.setBackgroundColor(getResources().getColor(R.color.main));

        tv_total=(TextView)v.findViewById(R.id.tv_total);
        iv_increase=(ImageView) v.findViewById(R.id.iv_increase);
        decrease=(ImageView)v.findViewById(R.id.iv_decrease);
        iv_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minteger = minteger + 1;
                display(minteger);
            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minteger = minteger - 1;
                display(minteger);
            }
        });

        return v;

    }
    private void display(int number) {

        tv_total.setText("" + number);
    }


}
