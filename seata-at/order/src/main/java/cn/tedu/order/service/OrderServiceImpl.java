package cn.tedu.order.service;

import cn.tedu.order.entity.Order;
import cn.tedu.order.feign.AccountClient;
import cn.tedu.order.feign.EasyIdGeneratorClient;
import cn.tedu.order.feign.StorageClient;
import cn.tedu.order.mapper.OrderMapper;
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
    public void create(Order order) {
        //TODO:从全局唯一ID发号器获取id 这里随机产生一个ORDERID
        Long orderId = easyIdGeneratorClient.nextId("order_business");
        order.setId(orderId);
        orderMapper.create(order);
        //TODO:调用storage 修改库存
        storageClient.decrease(order.getProductId(),order.getCount());
        //TODO:调用account 修改账户余额
        accountClient.decrease(order.getUserId(),order.getMoney());
    }
}
