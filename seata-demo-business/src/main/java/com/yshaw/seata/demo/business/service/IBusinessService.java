package com.yshaw.seata.demo.business.service;

/**
 * @author xdl
 * @date 2021-04-20
 */
public interface IBusinessService {

    /**
     * 采购
     */
    int purchase(String userId, String commodityCode, int orderCount);

}
