package com.yshaw.seata.demo.storage.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xdl
 * @date 2021-04-20
 */
public class StorageFeignFallback implements StorageFeign {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageFeignFallback.class);

    private Throwable throwable;

    public StorageFeignFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public int deduct(String commodityCode, int count) {
        LOGGER.error("StorageFeignFallback.deduct: {}", throwable.getMessage());
        return -1;
    }
}
