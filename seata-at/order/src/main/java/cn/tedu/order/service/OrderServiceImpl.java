package cn.tedu.order.service;

import cn.tedu.order.entity.Order;
import cn.tedu.order.feign.AccountClient;
import cn.tedu.order.feign.EasyIdGeneratorClient;
import cn.tedu.order.feign.StorageClient;
import cn.tedu.order.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Date 2020/9/5 10:07
 * @Author yangce
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EasyIdGeneratorClient easyIdGeneratorClient;
    @Autowired
    private StorageClient storageClient;
    @Autowired
    private AccountClient accountClient;
    @Override
    @GlobalTransactional
    public void create(Order order) {
        Long orderId = easyIdGeneratorClient.nextId("order_business");
        order.setId(orderId);
        orderMapper.create(order);
//        if (Math.random() < 0.5) {
//            throw new RuntimeException("模拟异常");
//        }
        storageClient.decrease(order.getProductId(),order.getCount());
        accountClient.decrease(order.getUserId(),order.getMoney());
    }
}
