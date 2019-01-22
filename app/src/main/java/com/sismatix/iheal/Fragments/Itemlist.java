package com.sismatix.iheal.Fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sismatix.iheal.DemoFragment;
import com.sismatix.iheal.R;
import com.sismatix.iheal.libs.AppBarStateChangeListener;
import com.sismatix.iheal.libs.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class Itemlist extends Fragment {

    Toolbar mToolbar;
    CollapsingToolbarLayout mCollapsingToolbar;
    AppBarLayout mAppBarLayout;
    TabLayout mTabLayout;
    TextView mToolbarTextView;
    KenBurnsView mHeaderImageView;
    View mContainerView;
    ViewPager mViewPager;
    ViewPagerAdapter mAdapter;

   /* private CollapsingToolbarLayout collapsingToolbar;
    private AppBarLayout appBarLayout;
    private boolean appBarExpanded = true;
*/
    public Itemlist() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_itemlist, container, false);
        //((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        /*Toolbar toolbar = (Toolbar)v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (getActivity().getActionBar() != null)
            getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

        //appBarLayout = (AppBarLayout)v.findViewById(R.id.appBar);

        collapsingToolbar = (CollapsingToolbarLayout)v.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("iHeal");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_shopping_cart_black_36dp);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {
                int vibrantColor = palette.getVibrantColor(R.color.main);
                collapsingToolbar.setContentScrimColor(vibrantColor);
                collapsingToolbar.setStatusBarScrimColor(R.color.main);
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                //  Vertical offset == 0 indicates appBar is fully expanded.
                if (Math.abs(verticalOffset) > 200) {
                    appBarExpanded = false;
                    ((AppCompatActivity) getActivity()).invalidateOptionsMenu();
                } else {
                    appBarExpanded = true;
                    ((AppCompatActivity) getActivity()).invalidateOptionsMenu();
                }
            }
        });*/

        findViews(v);
        setUpViews();

        return v;
    }
    private void findViews(View v) {
        mToolbar = (Toolbar)v.findViewById(R.id.toolbar);
        mToolbarTextView = (TextView) v.findViewById(R.id.toolbar_title);
        mCollapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
        mAppBarLayout = (AppBarLayout) v.findViewById(R.id.app_bar);
        mTabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        mHeaderImageView = (KenBurnsView) v.findViewById(R.id.imageView_header);
        mContainerView = v.findViewById(R.id.view_container);

        mViewPager = (ViewPager) v.findViewById(R.id.viewPager);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mHeaderImageView != null) {
            mHeaderImageView.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mHeaderImageView != null) {
            mHeaderImageView.pause();
        }
    }

    private void setUpViews() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mCollapsingToolbar.setTitleEnabled(false);
        mCollapsingToolbar.getLayoutParams().height =
                (Utils.isLand(getContext()) ? Utils.getDisplayDimen(getContext()).y :
                        Utils.getDisplayDimen(getContext()).x) * 9 / 16 +
                        Utils.getStatusBarHeightPixel(getContext());
        mCollapsingToolbar.requestLayout();

        // TODO : Hack for CollapsingToolbarLayout
        mToolbarTextView.setText("Demo");
        actionBarResponsive();
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {

            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (mToolbarTextView != null) {
                    if (state == State.COLLAPSED) {
                        if (Build.VERSION.SDK_INT >= 11) {
                            mToolbarTextView.setAlpha(1);
                        } else {
                            setAlphaForView(mToolbarTextView, 1);
                        }
                        mCollapsingToolbar.setContentScrimColor(
                                ContextCompat.getColor(getContext(), R.color.colorPrimary));
                    } else if (state == State.EXPANDED) {
                        if (Build.VERSION.SDK_INT >= 11) {
                            mToolbarTextView.setAlpha(0);
                        } else {
                            setAlphaForView(mToolbarTextView, 0);
                        }
                        mCollapsingToolbar.setContentScrimColor(ContextCompat
                                .getColor(getContext(), android.R.color.transparent));
                    }
                }
            }

            @Override
            public void onOffsetChanged(State state, float offset) {
                if (mToolbarTextView != null) {
                    if (state == State.IDLE) {
                        if (Build.VERSION.SDK_INT >= 11) {
                            mToolbarTextView.setAlpha(offset);
                            mCollapsingToolbar.setContentScrimColor(
                                    (int) new android.animation.ArgbEvaluator().evaluate(offset,
                                            ContextCompat.getColor(getContext(),
                                                    android.R.color.transparent), ContextCompat
                                                    .getColor(getContext(),
                                                            R.color.colorPrimary)));
                        } else {
                            setAlphaForView(mToolbarTextView, offset);
                            mCollapsingToolbar.setContentScrimColor((int) new ArgbEvaluator()
                                    .evaluate(offset, ContextCompat.getColor(getContext(),
                                            android.R.color.transparent), ContextCompat
                                            .getColor(getContext(), R.color.colorPrimary)));
                        }
                    }
                }
            }
        });

        mAdapter = new ViewPagerAdapter(((AppCompatActivity) getActivity()).getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(mAdapter.getCount());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        String imageUri = "drawable://" + R.drawable.category;
        //ImageLoader.getInstance().displayImage("drawable://"+imageUri, mHeaderImageView, Utils.getDisplayImageBuilder().build());

        // If your CollapsingToolbarLayout too complex (e.g. ImageView into FrameLayout), then
        // your status bar may looks so buggy.
        // You can hotfix by this code when you need to use some 24.2.0's features,
        // or you can wait for Google fix this (24.2.1), or downgrade to 24.1.1.
        // The issue: http://goo.gl/FMWs37
        ViewCompat
                .setOnApplyWindowInsetsListener(mContainerView, new OnApplyWindowInsetsListener() {

                    @Override
                    public WindowInsetsCompat onApplyWindowInsets(View v,
                                                                  WindowInsetsCompat insets) {
                        return insets.consumeSystemWindowInsets();
                    }
                });
    }

    private void setAlphaForView(View v, float alpha) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(alpha, alpha);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

    private void actionBarResponsive() {
        int actionBarHeight = Utils.getActionBarHeightPixel(getContext());
        int tabHeight = Utils.getTabHeight(getContext());
        if (actionBarHeight > 0) {
            mToolbar.getLayoutParams().height = actionBarHeight + tabHeight;
            mToolbar.requestLayout();
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return new DemoFragment();
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Demo " + position;
        }
    }

}
