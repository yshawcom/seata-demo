package com.yshaw.seata.demo.account.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xdl
 * @date 2021-04-20
 */
public class AccountFeignFallback implements AccountFeign {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountFeignFallback.class);

    private Throwable throwable;

    public AccountFeignFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public int debit(String userId, int money) {
        LOGGER.error("AccountFeignFallback.debit: {}", throwable.getMessage());
        return -1;
    }

}
