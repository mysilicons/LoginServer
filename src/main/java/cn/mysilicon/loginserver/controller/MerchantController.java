package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.mapper.MerchantMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    private String token;
    @Resource
    MerchantMapper merchantMapper;

    @PostMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password) {
        token = merchantMapper.login(username, password);
        return token;
    }

    @PostMapping("/register")
    public String register(@Param("username") String username, @Param("password") String password) {
        //判断用户是否存在
        if (merchantMapper.selectByName(username)) {
            return "用户已存在";
        }
        //生成token
        token = UUID.randomUUID().toString();
        merchantMapper.register(username, password, token);
        return "注册成功";
    }
}
