package com.yshaw.seata.demo.order.rest.service.impl;

import com.yshaw.seata.demo.account.api.AccountFeign;
import com.yshaw.seata.demo.order.rest.dao.IOrderDao;
import com.yshaw.seata.demo.order.rest.model.Order;
import com.yshaw.seata.demo.order.rest.service.IOrderService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author xdl
 * @date 2021-04-20
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final AccountFeign accountFeign;
    private final IOrderDao orderDao;
    private Random random;

    public OrderServiceImpl(IOrderDao orderDao, AccountFeign accountFeign) {
        this.orderDao = orderDao;
        this.accountFeign = accountFeign;
        this.random = new Random();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int create(String userId, String commodityCode, int orderCount) {
        LOGGER.info("订单服务开始 ... xid: " + RootContext.getXID());

        int orderMoney = calculate(commodityCode, orderCount);

        // 扣款
        int accountResult = accountFeign.debit(userId, orderMoney);
        if (accountResult == -1) {
            throw new RuntimeException("账户服务降级");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        orderDao.save(order);

//        if (random.nextBoolean()) {
//            throw new RuntimeException("这个是模拟的异常");
//        }

        LOGGER.info("订单服务结束 ... Created " + order);
        return 0;
    }

    private int calculate(String commodityCode, int orderCount) {
        // 假设商品单价为 2
        return 2 * orderCount;
    }

}
