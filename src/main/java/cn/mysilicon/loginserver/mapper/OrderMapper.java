package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO hp_orders(`order_number`, user_id, address_id, classification2_id, classification2_name, service_id, `name`, content, price, image, server_time, address)\n" +
            "SELECT\n" +
            "  #{order_number} AS `order_number`,\n" +
            "  hp_users.id AS user_id,\n" +
            "  hp_address.id AS address_id,\n" +
            "  hp_service.classification2 AS classification2_id,\n" +
            "  hp_classification.classification2_name AS classification2_name,\n" +
            "  hp_service.id AS service_id,\n" +
            "  hp_service.title AS `name`,\n" +
            "  hp_service.content AS content,\n" +
            "  hp_service.price AS price,\n" +
            "  hp_service.image_url AS image,\n" +
            "  #{server_time} AS server_time,\n" +
            "  hp_address.address AS address\n" +
            "FROM hp_service\n" +
            "INNER JOIN hp_classification\n" +
            "ON hp_service.classification2=hp_classification.classification2_id AND hp_service.id =#{service_id}\n" +
            "INNER JOIN hp_address\n" +
            "ON hp_address.id=#{address_id}\n" +
            "INNER JOIN hp_users\n" +
            "ON hp_users.id=#{user_id};")
    void order(long order_number, String server_time, Integer service_id, Integer address_id, Integer user_id);

    @Select("SELECT * FROM hp_orders WHERE user_id=#{user_id}")
    List<Order> selectAll(Integer user_id);

    @Delete("DELETE FROM hp_orders WHERE id=#{id}")
    void delete(Integer id);

    @Update("UPDATE hp_orders SET cur_status='已完成' WHERE id=#{id}")
    void finish(Integer id);

}
