package cn.mysilicon.loginserver.controller;


import cn.mysilicon.loginserver.entity.User;
import cn.mysilicon.loginserver.mapper.UserMapper;
import cn.mysilicon.loginserver.util.Response;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    UserMapper userMapper;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Response loginUser(@RequestBody User user) {
        String uname = user.getUname();
        String pwd = user.getPwd();
        Integer uid = userMapper.getIdByName(uname);
        //System.out.println("uname=" + uname + "pwd" + pwd);
        if (uname.equals("") || pwd.equals("")) {
            return new Response(uid,uname,100, "用户名或密码不能为空", "");
        } else {
            if (userMapper.login(uname, pwd) != null) {
                return new Response(uid,uname,200, "操作成功", "");
            } else {
                return new Response(uid,uname,500, "用户不存在/密码错误", "");
            }
        }
    }

    @PostMapping("/register")
    public Response register(@RequestBody User user) {
        String uname = user.getUname();
        String pwd = user.getPwd();
        if (uname.equals("") || pwd.equals("")) {
            Integer uid = 0;
            return new Response(uid,uname,100, "用户名或密码不能为空", "");
        } else {
            if (userMapper.registerByName(user.getUname()) == null) {
                userMapper.register(user);
                Integer uid = userMapper.getIdByName(uname);
                return new Response(uid,uname,200, "操作成功", "");
            } else {
                Integer uid = userMapper.getIdByName(uname);
                return new Response(uid,uname,500, "注册失败", "用户已存在");
            }
        }
    }

}

