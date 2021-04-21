package com.yshaw.seata.demo.storage.rest.controller;

import com.yshaw.seata.demo.storage.rest.service.IStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xdl
 * @date 2021-04-20
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageController.class);

    private final IStorageService storageService;

    public StorageController(IStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("deduct")
    public int deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count) {
        return storageService.deduct(commodityCode, count);
    }

}
