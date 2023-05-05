package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.Comment;
import cn.mysilicon.loginserver.mapper.CommentMapper;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Resource
    CommentMapper commentMapper;

    @GetMapping("/comment/list")
    public String commentList(@Param("service_id") Integer service_id) {
        List<Comment> commentList = commentMapper.findAll(service_id);
        String result = JSON.toJSONString(commentList);
        return result;
    }

    @PostMapping("/comment/add")
    public void commentAdd(@Param("service_id") Integer service_id,
                           @Param("user_id") Integer user_id,
                           @Param("comment") String comment) {
        commentMapper.add(service_id, user_id, comment);
    }

    @GetMapping("/comment/getCommentByUserId")
    public String getCommentByUserId(@Param("user_id") Integer user_id) {
        List<Comment> commentList = commentMapper.getCommentByUserId(user_id);
        String result = JSON.toJSONString(commentList);
        return result;
    }

}
