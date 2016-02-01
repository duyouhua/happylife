package com.licrafter.happylife.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.licrafter.happylife.R;
import com.licrafter.happylife.base.BaseFragment;
import com.licrafter.happylife.ui.adapter.CategoryAdapter;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/2/2.
 */
public class CategoryFragment extends BaseFragment {

    @Bind(R.id.categoryTabLayout)
    TabLayout categoryTabLayout;
    @Bind(R.id.categoryViewPager)
    ViewPager categoryViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public void initViews(View view) {
        categoryTabLayout.setTabMode(TabLayout.MODE_FIXED);
        categoryTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        categoryTabLayout.setTabTextColors(getResources().getColor(R.color.grey), getResources().getColor(R.color.white));
        ViewCompat.setElevation(categoryTabLayout, getResources().getDimension(R.dimen.appbar_elevation));
        categoryViewPager.setAdapter(new CategoryAdapter(getChildFragmentManager()));
        categoryTabLayout.setupWithViewPager(categoryViewPager);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initData() {

    }
}
