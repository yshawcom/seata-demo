package com.yshaw.seata.demo.storage.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xdl
 * @date 2021-04-20
 */
@FeignClient(name = "seata-demo-storage", fallbackFactory = StorageFeignFallbackFactory.class)
public interface StorageFeign {

    @PostMapping("storage/deduct")
    int deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);

}
