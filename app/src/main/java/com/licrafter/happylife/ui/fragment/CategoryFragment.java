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
        android.util.Log.d("ljx",datas.size()+"多少");
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onDestroy() {
        this.categoryListPresenter.detachView();
        super.onDestroy();
    }
}
