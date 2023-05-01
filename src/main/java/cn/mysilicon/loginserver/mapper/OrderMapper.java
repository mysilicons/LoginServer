package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("""
            INSERT INTO hp_orders(`order_number`, user_id, address_id, classification2_id, classification2_name, service_id, `name`, content, price, image, server_time, username, phone, address, merchant_id)
            SELECT
              #{order_number} AS `order_number`,
              hp_users.id AS user_id,
              hp_address.id AS address_id,
              hp_service.classification2 AS classification2_id,
              hp_classification.classification2_name AS classification2_name,
              hp_service.id AS service_id,
              hp_service.title AS `name`,
              hp_service.content AS content,
              hp_service.price AS price,
              hp_service.image_url AS image,
              #{server_time} AS server_time,
              hp_address.uname AS username,
              hp_address.phone AS phone,
              hp_address.address AS address,
              #{merchant_id} AS merchant_id
            FROM hp_service
            INNER JOIN hp_classification
            ON hp_service.classification2=hp_classification.classification2_id AND hp_service.id =#{service_id}
            INNER JOIN hp_address
            ON hp_address.id=#{address_id}
            INNER JOIN hp_users
            ON hp_users.id=#{user_id};""")
    void order(long order_number, String server_time, Integer service_id, Integer address_id, Integer user_id, Integer merchant_id);

    @Select("SELECT * FROM hp_orders WHERE user_id=#{user_id} AND user_visible=1")
    List<Order> selectAll(Integer user_id);

    @Update("UPDATE hp_orders SET user_visible=0 WHERE id=#{id}")
    void userdelete(Integer id);

    @Update("UPDATE hp_orders SET cur_status='已完成' WHERE id=#{id}")
    void finish(Integer id);

    @Select("SELECT merchant_id FROM hp_service WHERE id=#{serviceId}")
    Integer getMerchantId(Integer serviceId);

    @Select("SELECT * FROM hp_orders WHERE id=#{id}")
    Order select(Integer id);
}
