package cn.tedu.order.controller;

import cn.tedu.order.entity.Order;
import cn.tedu.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/9/5 10:08
 * @Author yangce
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/create")
    public String create(Order order){
        log.info("创建订单入参为 {}",order.toString());
        orderService.create(order);
        return "创建成功";
    }
    @GetMapping("/actuator/info")
    public String info(){
        return "心跳检测正常";
    }
}
