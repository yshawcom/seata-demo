package com.yshaw.seata.demo.business.controller;

import com.yshaw.seata.demo.business.service.IBusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xdl
 * @date 2021-04-20
 */
@RestController
@RequestMapping("business")
public class BusinessController {

    private final IBusinessService businessService;

    public BusinessController(IBusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping("purchase")
    public int purchase(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                        @RequestParam("orderCount") int orderCount) {
        return businessService.purchase(userId, commodityCode, orderCount);
    }

}
