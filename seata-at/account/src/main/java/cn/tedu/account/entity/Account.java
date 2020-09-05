package cn.tedu.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Date 2020/9/5 9:39
 * @Author yangce
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
    private BigDecimal frozen;
}
