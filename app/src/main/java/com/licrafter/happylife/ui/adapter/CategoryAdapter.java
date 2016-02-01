package com.licrafter.happylife.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.licrafter.happylife.ui.fragment.NodesFragment;

/**
 * Created by Administrator on 2016/2/2.
 */
public class CategoryAdapter extends FragmentStatePagerAdapter {


    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return NodesFragment.newInstance();
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
