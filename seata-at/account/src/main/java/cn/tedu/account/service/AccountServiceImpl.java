package cn.tedu.account.service;

import cn.tedu.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Date 2020/9/5 9:42
 * @Author yangce
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountMapper.decrease(userId,money);
    }
}
