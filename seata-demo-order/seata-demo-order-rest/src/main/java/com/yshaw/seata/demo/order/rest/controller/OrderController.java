package com.yshaw.seata.demo.order.rest.controller;

import com.yshaw.seata.demo.order.rest.service.IOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xdl
 * @date 2021-04-20
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("create")
    public int create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                       @RequestParam("orderCount") int orderCount) {
        return orderService.create(userId, commodityCode, orderCount);
    }

}
