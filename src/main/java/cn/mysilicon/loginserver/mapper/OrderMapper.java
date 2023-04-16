package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO my_orders(shop_id,shop_name,product_id,title,content,price,image_url)\n" +
            "SELECT shop_id, shop_name, service_list.id AS product_id, title, content, price, image_url\n" +
            "FROM service_list \n" +
            "INNER JOIN order_data \n" +
            "ON service_list.classification=order_data.shop_id \n" +
            "WHERE service_list.id=#{product_id}")
    void buy(Integer product_id);

    @Select("SELECT * FROM my_orders")
    List<Order> selectAll();

    @Delete("DELETE FROM my_orders WHERE id=#{id}")
    void delete(Integer id);

    @Update("UPDATE my_orders SET cur_status='已完成' WHERE id=#{id}")
    void finish(Integer id);

}
