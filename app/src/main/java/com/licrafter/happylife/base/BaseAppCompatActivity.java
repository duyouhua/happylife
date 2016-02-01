package com.licrafter.happylife.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.licrafter.happylife.R;
import com.licrafter.happylife.util.SharedPreferencesUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/1/31.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(this.getLayoutId());
        ButterKnife.bind(this);
        SharedPreferencesUtil.init(getApplicationContext());
        this.initToolbar(savedInstanceState);
        this.initData();
        this.initView(savedInstanceState);
        this.initListener();
    }

    /**
     * 设置layout id
     *
     * @return
     */
    protected abstract int getLayoutId();

    protected abstract void initToolbar(Bundle savedInstanceState);

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void initListener();

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
