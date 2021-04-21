package com.yshaw.seata.demo.account.rest.controller;

import com.yshaw.seata.demo.account.rest.service.IAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xdl
 * @date 2021-04-20
 */
@RestController
@RequestMapping("account")
public class AccountController {

    private IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 从用户账户中借出
     *
     * @param userId
     * @param money
     */
    @PostMapping("debit")
    public int debit(@RequestParam("userId") String userId, @RequestParam("money") int money) {
        return accountService.debit(userId, money);
    }

}
