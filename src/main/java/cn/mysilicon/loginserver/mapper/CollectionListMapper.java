package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectionListMapper {
    @Select("SELECT * FROM hp_collection WHERE classification2_id=#{classification2_id}")
    List<Collection> selectByShopId(Integer classification2_id);
}
