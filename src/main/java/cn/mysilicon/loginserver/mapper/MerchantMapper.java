package cn.mysilicon.loginserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MerchantMapper {
    @Select("SELECT token FROM hp_merchant WHERE username=#{username} AND password=#{password}")
    String login(String username, String password);

    @Select("INSERT INTO hp_merchant(username, password, token) VALUES(#{username}, #{password}, #{token})")
    void register(String username, String password, String token);

    @Select("SELECT * FROM hp_merchant WHERE username=#{username}")
    boolean selectByName(String username);
}
