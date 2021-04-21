package com.yshaw.seata.demo.account.rest.service.impl;

import com.yshaw.seata.demo.account.rest.dao.IAccountDao;
import com.yshaw.seata.demo.account.rest.model.Account;
import com.yshaw.seata.demo.account.rest.service.IAccountService;
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
public class AccountServiceImpl implements IAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private Random random;
    private IAccountDao accountDao;

    public AccountServiceImpl(IAccountDao accountDao) {
        this.accountDao = accountDao;
        this.random = new Random();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int debit(String userId, int money) {
        LOGGER.info("账户服务开始 ... xid: " + RootContext.getXID());

//        if (random.nextBoolean()) {
//            throw new RuntimeException("这是个模拟的异常");
//        }

        Account account = accountDao.findTopByUserId(userId);
        if (account == null) {
            throw new RuntimeException("没有用户 " + userId);
        }

        int remainingMoney = account.getMoney() - money;
        if (remainingMoney < 0) {
            throw new RuntimeException("用户 " + userId + " 余额不足");
        }
        account.setMoney(remainingMoney);
        accountDao.save(account);

        LOGGER.info("账户服务结束 ... ");
        return 0;
    }

}
