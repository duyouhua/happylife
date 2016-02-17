package com.licrafter.happylife.model.impl;

import com.licrafter.happylife.api.HappyLife;
import com.licrafter.happylife.data.GoodsData;
import com.licrafter.happylife.model.IGoodsModel;

import rx.Observable;

/**
 * Created by Administrator on 2016/2/17.
 */
public class GoodsModel implements IGoodsModel {

    private static GoodsModel instance;

    public static GoodsModel getInstance() {
        if (instance == null) {
            instance = new GoodsModel();
        }
        return instance;
    }

    /**
     * 分页查询商品列表
     *
     * @param type 种类
     * @param page 页码
     * @param size 每页数量
     * @return
     */
    @Override
    public Observable<GoodsData> getGoodsByType(String type, int page, int size) {

        return null;
    }

    /**
     * 分页查询所有商品列表
     *
     * @param page 页码
     * @param size 每页数量
     * @return
     */
    @Override
    public Observable<GoodsData> getAllGoods(int page, int size) {

        return HappyLife.getInstance().getHappyService().getAllGoods("createdAt");
    }
}
