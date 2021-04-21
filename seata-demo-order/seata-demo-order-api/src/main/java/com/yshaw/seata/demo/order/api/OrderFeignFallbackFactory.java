package com.yshaw.seata.demo.order.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author xdl
 * @date 2021-04-20
 */
@Component
public class OrderFeignFallbackFactory implements FallbackFactory<OrderFeignFallback> {

    @Override
    public OrderFeignFallback create(Throwable throwable) {
        return new OrderFeignFallback(throwable);
    }

}
