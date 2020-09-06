package cn.tedu.account.service;

import cn.tedu.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Date 2020/9/5 9:42
 * @Author yangce
 */
@Service
public class AccountServiceImpl implements AccountService{
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private AccountMapper accountMapper;
    @Override
    @Transactional
    public void decrease(Long userId, BigDecimal money) {
        accountMapper.decrease(userId,money);
            if (Math.random() < 0.5) {
            throw new RuntimeException("模拟异常");
        }
    }
}
