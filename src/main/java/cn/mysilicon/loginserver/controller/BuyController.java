package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.Order;
import cn.mysilicon.loginserver.mapper.OrderMapper;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyController {

    @Resource
    OrderMapper orderMapper;

    @PostMapping("/myorders/buy")
    public void buy(@Param("product_id")Integer product_id) {
        orderMapper.buy(product_id);
    }

    @GetMapping("/myorders/all")
    public String getAll() {
        List<Order> orderList = orderMapper.selectAll();
        return JSON.toJSONString(orderList);
    }
}
