package com.yshaw.seata.demo.storage.rest.service;

/**
 * @author xdl
 * @date 2021-04-20
 */
public interface IStorageService {

    /**
     * 扣除存储数量
     */
    int deduct(String commodityCode, int count);

}
