package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.Order;
import cn.mysilicon.loginserver.mapper.OrderMapper;
import cn.mysilicon.loginserver.util.SnowflakeIdGenerator;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderMapper orderMapper;

    @GetMapping("/list")
    public String getAll(@Param("user_id") Integer user_id) {
        List<Order> orderList = orderMapper.selectAll(user_id);
        return JSON.toJSONString(orderList);
    }

    @PostMapping("/add")
    public void order(@Param("server_time") String server_time,
                      @Param("service_id") Integer service_id,
                      @Param("address_id") Integer address_id,
                      @Param("user_id") Integer user_id) {
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(18L, 27L);
        long order_number = snowflakeIdGenerator.nextId();
        Integer merchant_id = orderMapper.getMerchantId(service_id);
        orderMapper.order(order_number, server_time, service_id, address_id, user_id, merchant_id);
    }

    @GetMapping("/get")
    public String get(@Param("id") Integer id) {
        Order order = orderMapper.select(id);
        return JSON.toJSONString(order);
    }

    @PostMapping("/delete")
    public void delete(@Param("id") Integer id) {
        orderMapper.userdelete(id);
    }

    @PostMapping("/finish")
    public void finish(@Param("id") Integer id) {
        orderMapper.finish(id);
    }

    @PostMapping("/cancel")
    public void cancel(@Param("id") Integer id) {
        orderMapper.cancel(id);
    }
}
