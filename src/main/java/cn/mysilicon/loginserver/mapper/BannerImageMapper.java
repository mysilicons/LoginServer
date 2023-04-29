package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.BannerImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerImageMapper {

    @Select("select * from hp_banner_image")
    List<BannerImage> selectAll();
}
