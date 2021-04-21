package com.yshaw.seata.demo.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xdl
 * @date 2021-04-20
 */
@FeignClient(name = "seata-demo-order", fallbackFactory = OrderFeignFallbackFactory.class)
public interface OrderFeign {

    @PostMapping("order/create")
    int create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                @RequestParam("orderCount") int orderCount);

}
