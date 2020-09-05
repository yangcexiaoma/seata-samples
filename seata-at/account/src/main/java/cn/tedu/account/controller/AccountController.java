package cn.tedu.account.controller;

import cn.tedu.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Date 2020/9/5 9:40
 * @Author yangce
 */
@RestController
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/decrease")
    public String decrease(Long userId, BigDecimal money){
        accountService.decrease(userId,money);
        System.out.println("用户账户扣减金额成功");
        return "用户账户扣减金额成功";

    }
    @GetMapping("/actuator/info")
    public String info(){
        return "心跳检测正常";
    }
}
