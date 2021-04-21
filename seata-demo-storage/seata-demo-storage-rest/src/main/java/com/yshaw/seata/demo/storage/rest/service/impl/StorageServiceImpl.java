package com.yshaw.seata.demo.storage.rest.service.impl;

import com.yshaw.seata.demo.storage.rest.dao.IStorageDao;
import com.yshaw.seata.demo.storage.rest.model.Storage;
import com.yshaw.seata.demo.storage.rest.service.IStorageService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xdl
 * @date 2021-04-20
 */
@Service
public class StorageServiceImpl implements IStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    private final IStorageDao storageDao;

    public StorageServiceImpl(IStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int deduct(String commodityCode, int count) {
        LOGGER.info("库存服务开始 ... xid: " + RootContext.getXID());

        Storage storage = storageDao.findTopByCommodityCode(commodityCode);
        if (storage == null) {
            throw new RuntimeException("没有商品 " + commodityCode);
        }

        int remainingCount = storage.getCount() - count;
        if (remainingCount < 0) {
            throw new RuntimeException("商品 " + commodityCode + " 剩余库存数量不足");
        }
        storage.setCount(storage.getCount() - count);
        storageDao.save(storage);

        LOGGER.info("库存服务结束 ... ");
        return 0;
    }

}
