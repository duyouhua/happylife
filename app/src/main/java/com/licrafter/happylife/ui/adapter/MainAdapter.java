package com.licrafter.happylife.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.licrafter.happylife.ui.fragment.CategoryFragment;
import com.licrafter.happylife.ui.fragment.GodsListFragment;

/**
 * Created by Administrator on 2016/2/2.
 */
public class MainAdapter extends FragmentStatePagerAdapter {


    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return GodsListFragment.newInstance("all");
            case 1:
                return CategoryFragment.newInstance();
            default:
                return GodsListFragment.newInstance("all");
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "首页";
        return "分类";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
