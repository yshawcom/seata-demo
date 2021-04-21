package com.yshaw.seata.demo.order.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xdl
 * @date 2021-04-20
 */
public class OrderFeignFallback implements OrderFeign {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFeignFallback.class);

    private Throwable throwable;

    public OrderFeignFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public int create(String userId, String commodityCode, int orderCount) {
        LOGGER.error("OrderFeignFallback.create: {}", throwable.getMessage());
        return -1;
    }
}
