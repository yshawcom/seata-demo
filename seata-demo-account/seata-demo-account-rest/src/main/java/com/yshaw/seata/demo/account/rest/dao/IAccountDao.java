package com.yshaw.seata.demo.account.rest.dao;

import com.yshaw.seata.demo.account.rest.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xdl
 * @date 2021-04-20
 */
public interface IAccountDao extends JpaRepository<Account, Integer> {

    Account findTopByUserId(String userId);

}
