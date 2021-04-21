package com.yshaw.seata.demo.order.rest.service;

/**
 * @author xdl
 * @date 2021-04-20
 */
public interface IOrderService {

    /**
     * 创建订单
     */
    int create(String userId, String commodityCode, int orderCount);

}
