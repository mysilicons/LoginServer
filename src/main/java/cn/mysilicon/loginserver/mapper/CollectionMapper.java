package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.ShopData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionMapper {
    @Select("SELECT id,shop_id,shop_name FROM order_data")
    @Results({
            @Result(property = "shopId", column = "shop_id"),
            @Result(property = "shopName", column = "shop_name"),
            @Result(property = "cartlist", javaType = List.class, column = "shop_id",
                    many = @Many(select = "cn.mysilicon.loginserver.mapper.CartListMapper.selectByShopId"))
    })
    List<ShopData> selectAll();

    @Insert("INSERT INTO cartlist(shop_id, shop_name, product_id, product_name, price, default_pic)\n" +
            "SELECT shop_id,shop_name,service_list.id AS product_id,title AS product_name,price,image_url AS default_pic FROM service_list INNER JOIN order_data ON service_list.classification=order_data.shop_id WHERE service_list.id=#{id}")
    void addCollect(Integer id);

    @Delete("DELETE FROM cartlist WHERE product_id=#{id}")
    void deleteCollect(Integer id);

}
