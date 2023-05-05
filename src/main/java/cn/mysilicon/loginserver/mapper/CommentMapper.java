package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM hp_comment WHERE service_id=#{service_id}")
    List<Comment> findAll(Integer service_id);

    @Insert("""
            INSERT INTO hp_comment(service_id, merchant_id, user_id, `comment`)
            SELECT
            hp_service.id AS service_id,
            hp_merchant.id AS merchant_id,
            #{user_id} AS user_id,
            #{comment} AS `comment`
            FROM hp_service
            INNER JOIN hp_merchant
            WHERE hp_service.id=#{service_id} AND hp_merchant.id=hp_service.merchant_id;
            """)
    void add(Integer service_id, Integer user_id, String comment);

    @Select("SELECT * FROM hp_comment WHERE user_id=#{userId}")
    List<Comment> getCommentByUserId(Integer userId);
}
