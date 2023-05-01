package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Detail;
import cn.mysilicon.loginserver.entity.Service;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("SELECT * FROM hp_service WHERE id=#{id}")
    Service selectService(Integer id);

    @Update("UPDATE hp_service SET image_url=#{image_url}, title=#{title}, content=#{content}, price=#{price} WHERE id=#{id}")
    void updateService(Service service);

    @Delete("DELETE FROM hp_service WHERE id=#{id}")
    void deleteService(Integer id);
}
