package com.yshaw.seata.demo.storage.rest.dao;

import com.yshaw.seata.demo.storage.rest.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xdl
 * @date 2021-04-20
 */
public interface IStorageDao extends JpaRepository<Storage, Integer> {

    Storage findTopByCommodityCode(String commodityCode);

}
