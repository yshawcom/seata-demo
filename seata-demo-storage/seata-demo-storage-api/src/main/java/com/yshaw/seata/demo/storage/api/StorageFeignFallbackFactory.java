package com.yshaw.seata.demo.storage.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author xdl
 * @date 2021-04-20
 */
@Component
public class StorageFeignFallbackFactory implements FallbackFactory<StorageFeignFallback> {

    @Override
    public StorageFeignFallback create(Throwable throwable) {
        return new StorageFeignFallback(throwable);
    }

}

