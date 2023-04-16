package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Detail;
import cn.mysilicon.loginserver.entity.ServiceList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServiceListMapper {
    @Select("SELECT id, classification, image_url, title, content, price FROM service_list WHERE classification=#{classification}")
    List<ServiceList> selectByClassification(String classification);

    @Select("SELECT id,  image_url, title, content, price FROM service_list WHERE id=#{id}")
    List<Detail> selectById(Integer id);

    @Select("SELECT * FROM service_list")
    List<ServiceList> selectAll();
}
