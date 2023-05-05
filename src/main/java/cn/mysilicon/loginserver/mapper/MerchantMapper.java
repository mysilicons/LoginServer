package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Comment;
import cn.mysilicon.loginserver.entity.Order;
import cn.mysilicon.loginserver.entity.Service;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MerchantMapper {
    @Select("SELECT token FROM hp_merchant WHERE name=#{username} AND password=#{password}")
    String login(String username, String password);

    @Select("INSERT INTO hp_merchant(name, password, token) VALUES(#{username}, #{password}, #{token})")
    void register(String username, String password, String token);

    @Select("SELECT id FROM hp_merchant WHERE name=#{username}")
    Integer selectByName(String username);

    @Select("SELECT id FROM hp_merchant WHERE name=#{username}")
    int getUserId(String username);

    @Select("SELECT * FROM hp_orders WHERE merchant_id=#{merchant_id} AND merchant_visible=1")
    List<Order> selectAllOrder(Integer merchant_id);

    @Select("SELECT * FROM hp_service WHERE merchant_id=#{merchant_id}")
    List<Service> selectAllService(Integer merchantId);

    @Insert("INSERT INTO hp_service(classification1, classification2, image_url, title, content, price, city, merchant_id) VALUES(#{classification1}, #{classification2}, #{image_url}, #{title}, #{content}, #{price}, #{city}, #{merchant_id})")
    void release(Integer classification1, Integer classification2, String image_url, String title, String content, String price, String city, Integer merchant_id);

    @Select("SELECT * FROM hp_orders WHERE id=#{id}")
    Order selectOrder(Integer id);

    @Update("UPDATE hp_orders SET merchant_visible=0 WHERE id=#{id}")
    void merchantdelete(Integer id);

    @Select("SELECT name FROM hp_merchant WHERE id=#{merchantId}")
    String getConversationId(Integer merchantId);

    @Select("SELECT * FROM hp_comment WHERE merchant_id=#{merchantId}")
    List<Comment> getMerchantComment(Integer merchantId);
}
