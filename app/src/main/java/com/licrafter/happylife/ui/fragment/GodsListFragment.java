package com.licrafter.happylife.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.licrafter.happylife.MainActivity;
import com.licrafter.happylife.R;
import com.licrafter.happylife.base.BaseFragment;
import com.licrafter.happylife.data.ItemData;
import com.licrafter.happylife.data.entity.BaseGoodsData;
import com.licrafter.happylife.mvp.presenters.GoodsListPresenter;
import com.licrafter.happylife.mvp.views.GoodsListView;
import com.licrafter.happylife.ui.adapter.GoodsLoadMoreAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/2/2.
 */
public class GodsListFragment extends BaseFragment implements GoodsListView {

    @Bind(R.id.goodsRecyclerView)
    RecyclerView goodsRecyclerView;
    GoodsListPresenter goodsListPresenter;

    private MainActivity activity;
    private ArrayList<ItemData> goodsList;
    private GoodsAdapter goodsAdapter;

    public static GodsListFragment newInstance() {
        GodsListFragment fragment = new GodsListFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() != null && activity instanceof MainActivity) {
            this.activity = (MainActivity) activity;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDependencyInjector();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_list;
    }

    @Override
    public void initViews(View view) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new AutoSpanSizeLookUp());
        goodsRecyclerView.setLayoutManager(gridLayoutManager);
        goodsRecyclerView.setAdapter(goodsAdapter);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initData() {
        this.goodsListPresenter = new GoodsListPresenter();
        this.goodsListPresenter.attachView(this);
        goodsList = new ArrayList<>();
        this.goodsAdapter = new GoodsAdapter(getContext(), goodsList);
        if (goodsList.size() == 0) {
            this.goodsListPresenter.getGoods();
            this.goodsListPresenter.getBanner();
        }
    }


    @Override
    public void onGetGoodsSuccess(List<ItemData> goods, boolean refresh) {
        goodsList.addAll(goods);
        goodsList.add(0, new ItemData(ItemData.TYPE_BANNER, null));
        goodsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetBannerSuccess(ItemData banner) {
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onDestroy() {
        this.goodsListPresenter.detachView();
        super.onDestroy();
    }

    private void initializeDependencyInjector() {
//        DaggerFragmentComponent.builder()
//                .fragmentModule(new FragmentModule())
//                .activityComponent(activity.getActivityComponent())
//                .build()
//                .inject(this);
    }

    public class GoodsAdapter extends GoodsLoadMoreAdapter {

        public GoodsAdapter(Context context, ArrayList<ItemData> data) {
            super(context, data);
        }

        @Override
        protected void bindData(RecyclerView.ViewHolder holder, int position) {
            GoodsViewHolder vh = (GoodsViewHolder) holder;
            BaseGoodsData goods = (BaseGoodsData) mDatas.get(position).getData();
            Glide.with(context).load(goods.getIconUrl()).into(vh.goodsPicImageView);
            vh.goodsInfoTextView.setText(goods.getInfoStr());
            vh.goodsPriceTextView.setText("￥" + goods.getPrice());
            vh.goodsOldPriceTextView.setText(goods.getOldPrice() + "元");
        }
    }

    public class AutoSpanSizeLookUp extends GridLayoutManager.SpanSizeLookup{

        @Override
        public int getSpanSize(int position) {
            switch (goodsAdapter.getItemViewType(position)){
                case ItemData.TYPE_BANNER:
                    return 2;
                case ItemData.TYPE_GOODS:
                    return 1;
                case ItemData.TYPE_FOOTER:
                    return 1;
                default: return -1;
            }
        }
    }

}
