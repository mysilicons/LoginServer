package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.Order;
import cn.mysilicon.loginserver.entity.Service;
import cn.mysilicon.loginserver.mapper.MerchantMapper;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    private String token;
    private int id;
    private List<Order> orderList = new ArrayList<>();
    private List<Service> serviceList = new ArrayList<>();
    @Resource
    MerchantMapper merchantMapper;

    @PostMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password) {
        token = merchantMapper.login(username, password);
        id = merchantMapper.getUserId(username);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("username", username);
        map.put("id", id);
        String json = JSON.toJSONString(map);
        return json;
    }

    @PostMapping("/register")
    public String register(@Param("username") String username, @Param("password") String password) {
        //判断用户是否存在
        if (merchantMapper.selectByName(username) != null) {
            return "用户已存在";
        }
        //生成token
        token = UUID.randomUUID().toString();
        merchantMapper.register(username, password, token);
        return "注册成功";
    }

    @GetMapping("/order/list")
    public String getAllOrder(@Param("merchant_id") Integer merchant_id) {
        orderList = merchantMapper.selectAllOrder(merchant_id);
        return JSON.toJSONString(orderList);
    }

    @GetMapping("/order/get")
    public String getOrder(@Param("id") Integer id) {
        Order order = merchantMapper.selectOrder(id);
        return JSON.toJSONString(order);
    }

    @PostMapping("/order/delete")
    public void deleteOrder(@Param("id") Integer id) {
        merchantMapper.merchantdelete(id);
    }

    @GetMapping("/service/list")
    public String getAllService(@Param("merchant_id") Integer merchant_id) {
        serviceList = merchantMapper.selectAllService(merchant_id);
        return JSON.toJSONString(serviceList);
    }

    //接收前端传来的json数据，将其转换为Service对象，再将其存入数据库
    @PostMapping("/service/release")
    public void release(@RequestBody String service_json) {
        System.out.println("service_json = " + service_json);
        Service service = JSON.parseObject(service_json, Service.class);
        merchantMapper.release(service.getClassification1(), service.getClassification2(), service.getImage_url(), service.getTitle(), service.getContent(), service.getPrice(), service.getCity(), service.getMerchant_id());
    }
}
