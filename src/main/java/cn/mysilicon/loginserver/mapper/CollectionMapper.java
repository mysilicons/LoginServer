package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.CollectionData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionMapper {
    @Select("SELECT classification2_id, classification2_name FROM hp_collection WHERE user_id=#{user_id} GROUP BY classification2_id")
    @Results({
            @Result(property = "classification2_id", column = "classification2_id"),
            @Result(property = "classification2_name", column = "classification2_name"),
            @Result(property = "collectionList", javaType = List.class, column = "classification2_id",
                    many = @Many(select = "cn.mysilicon.loginserver.mapper.CollectionListMapper.selectByShopId")
            )
    })
    List<CollectionData> selectAll(Integer user_id);


    @Insert("INSERT INTO hp_collection(user_id, classification2_id, classification2_name, service_id, `name`, price, image)\n" +
            "SELECT \n" +
            "    hp_users.id AS user_id,\n" +
            "    hp_service.classification2 AS classification2_id,\n" +
            "    hp_classification.classification2_name AS classification2_name,\n" +
            "    hp_service.id AS service_id,\n" +
            "    hp_service.title AS `name`,\n" +
            "    hp_service.price AS price,\n" +
            "    hp_service.image_url AS image\n" +
            "FROM hp_service \n" +
            "INNER JOIN hp_classification \n" +
            "    ON hp_service.classification2 = hp_classification.classification2_id\n" +
            "INNER JOIN hp_users\n" +
            "    ON hp_users.id = #{user_id}\n" +
            "WHERE hp_service.id = #{service_id};\n")
    void addCollect(Integer user_id, Integer service_id);

    @Delete("DELETE FROM hp_classification WHERE id=#{id}")
    void deleteCollect(Integer id);
}
