package com.licrafter.happylife.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.licrafter.happylife.R;
import com.licrafter.happylife.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/2/2.
 */
public class NodesFragment extends BaseFragment {

    @Bind(R.id.nodesRecyclerView)
    RecyclerView nodesRecyclerView;

    public static NodesFragment newInstance() {
        NodesFragment fragment = new NodesFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_nodes;
    }

    @Override
    public void initViews(View view) {
        nodesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        nodesRecyclerView.setAdapter(new CusAdapter());
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initData() {

    }

    public class CusAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_node_layout,parent,false);
            return new CusViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 55;
        }

        public class CusViewHolder extends RecyclerView.ViewHolder{

            public CusViewHolder(View itemView) {
                super(itemView);
            }
        }
    }


}
