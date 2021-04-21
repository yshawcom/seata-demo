package com.yshaw.seata.demo.account.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author xdl
 * @date 2021-04-20
 */
@Component
public class AccountFeignFallbackFactory implements FallbackFactory<AccountFeignFallback> {

    @Override
    public AccountFeignFallback create(Throwable throwable) {
        return new AccountFeignFallback(throwable);
    }

}
