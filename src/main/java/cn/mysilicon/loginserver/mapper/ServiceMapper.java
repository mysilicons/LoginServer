package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Detail;
import cn.mysilicon.loginserver.entity.Service;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServiceMapper {
    @Select("SELECT * FROM hp_service WHERE classification2=#{classification2}")
    List<Service> selectByClassification2(Integer classification2);

    @Select("SELECT * FROM hp_service WHERE id=#{id}")
    Detail selectById(Integer id);

    @Select("SELECT * FROM hp_service")
    List<Service> selectAll();

    @Select("SELECT * FROM hp_service WHERE classification1=#{classification1}")
    List<Service> selectByclassification1(Integer classification1);
}
