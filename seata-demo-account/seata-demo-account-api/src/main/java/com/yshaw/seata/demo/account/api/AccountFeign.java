package com.yshaw.seata.demo.account.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xdl
 * @date 2021-04-20
 */
@FeignClient(name = "seata-demo-account", fallbackFactory = AccountFeignFallbackFactory.class)
public interface AccountFeign {

    /**
     * 从用户账户中消费
     *
     * @param userId
     * @param money
     */
    @PostMapping("account/debit")
    int debit(@RequestParam("userId") String userId, @RequestParam("money") int money);

}
