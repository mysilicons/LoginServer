package cn.mysilicon.loginserver.mapper;


import cn.mysilicon.loginserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface UserMapper {

    //登录
    @Select("select * from users where uname=#{uname} and pwd=#{pwd}")
    User login(@Param("uname")String uname, @Param("pwd") String pwd);

    //注册
    @Update("insert into users values(default,#{uname},#{pwd})")
    @Transactional
    void register(User user);

    //注册时判断用户是否存在
    @Select("select* from users where uname=#{uname}")
    @Transactional
    User  registerByName(String name);

    @Select("select id from users where uname=#{uname}")
    @Transactional
    int getIdByName(String name);


}

