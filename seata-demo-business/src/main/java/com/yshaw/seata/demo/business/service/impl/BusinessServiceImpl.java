package com.yshaw.seata.demo.business.service.impl;

import com.yshaw.seata.demo.business.service.IBusinessService;
import com.yshaw.seata.demo.order.api.OrderFeign;
import com.yshaw.seata.demo.storage.api.StorageFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xdl
 * @date 2021-04-20
 */
@Service
public class BusinessServiceImpl implements IBusinessService {

    private StorageFeign storageFeign;
    private OrderFeign orderFeign;

    public BusinessServiceImpl(StorageFeign storageFeign, OrderFeign orderFeign) {
        this.storageFeign = storageFeign;
        this.orderFeign = orderFeign;
    }

    @Override
    @GlobalTransactional
    @Transactional(rollbackFor = RuntimeException.class)
    public int purchase(String userId, String commodityCode, int orderCount) {
        // 扣库存
        int storageResult = storageFeign.deduct(commodityCode, orderCount);
        if (storageResult == -1) {
            throw new RuntimeException("库存服务降级");
        }
        // 下订单
        int orderResult = orderFeign.create(userId, commodityCode, orderCount);
        if (orderResult == -1) {
            throw new RuntimeException("订单服务降级");
        }
        return 0;
    }
}
