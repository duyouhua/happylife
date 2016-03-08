package com.licrafter.happylife.ui.fragment;

import android.os.Build;
import android.view.View;
import android.widget.GridView;

import com.licrafter.happylife.R;
import com.licrafter.happylife.base.BaseFragment;
import com.licrafter.happylife.data.entity.BaseCategoryData;
import com.licrafter.happylife.mvp.presenters.CategoryListPresenter;
import com.licrafter.happylife.mvp.views.CategoryListView;
import com.licrafter.happylife.ui.adapter.CategoryAdapter;
import com.licrafter.happylife.util.FragmentUtil;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/2/18.
 */
public class CategoryFragment extends BaseFragment implements CategoryListView {

    @Bind(R.id.categoryGridView)
    GridView categoryGridView;

    private CategoryListPresenter categoryListPresenter;
    private ArrayList<BaseCategoryData> categoryDatas;
    private int categoryCount;
    private CategoryAdapter categoryAdapter;

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void initViews(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            categoryGridView.setNestedScrollingEnabled(true);
        }
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initData() {
        categoryDatas = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getContext());
        categoryAdapter.setOnItemClickListener(listener);
        categoryGridView.setAdapter(categoryAdapter);
        this.categoryListPresenter = new CategoryListPresenter();
        this.categoryListPresenter.attachView(this);
        if (categoryDatas.size() == 0) {
            categoryListPresenter.getCategories();
        }
    }

    @Override
    public void onGetCategorySuccess(ArrayList<BaseCategoryData> datas) {
        categoryDatas = datas;
        categoryAdapter.setData(categoryDatas);
    }

    private CategoryAdapter.OnItemClickListener listener = new CategoryAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(String category,String title) {
            getBaseActivity().switchFragment(GodsListFragment.newInstance(category,title),true);
        }
    };

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onDestroyView() {
        this.categoryListPresenter.detachView();
        super.onDestroyView();
    }
}
