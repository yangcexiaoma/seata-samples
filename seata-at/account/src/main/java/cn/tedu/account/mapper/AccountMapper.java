package cn.tedu.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

public interface AccountMapper extends BaseMapper<AccountMapper> {
    void decrease(Long userId, BigDecimal money);
}
