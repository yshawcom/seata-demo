package com.yshaw.seata.demo.order.rest.dao;

import com.yshaw.seata.demo.order.rest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xdl
 * @date 2021-04-20
 */
public interface IOrderDao extends JpaRepository<Order, Integer> {
}
