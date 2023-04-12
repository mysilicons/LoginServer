package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.CartList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartListMapper {
    @Select("SELECT id, shop_id, shop_name, product_id, product_name, price, default_pic FROM cartlist WHERE shop_id=#{shop_id}")
    List<CartList> selectByShopId(int shop_id);
}
