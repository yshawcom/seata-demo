package com.yshaw.seata.demo.account.rest.service;

/**
 * @author xdl
 * @date 2021-04-20
 */
public interface IAccountService {

    /**
     * 从用户账户中消费
     *
     * @param userId
     * @param money
     */
    int debit(String userId, int money);

}
