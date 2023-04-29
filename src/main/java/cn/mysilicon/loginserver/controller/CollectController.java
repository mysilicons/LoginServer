package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.CollectionData;
import cn.mysilicon.loginserver.mapper.CollectionMapper;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private CollectionMapper collectionMapper;

    @GetMapping("/list")
    public String getCollect(@Param("user_id") Integer user_id) {
        List<CollectionData> shopDataList = collectionMapper.selectAll(user_id);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("orderData", shopDataList);
        return new JSONObject(resultMap).toJSONString();
    }

    @PostMapping("/add")
    public void addCollect(@Param("user_id") Integer user_id, @Param("service_id") Integer service_id) {
        collectionMapper.addCollect(user_id, service_id);
    }

    @PostMapping("/delete")
    public void deleteCollect(@Param("id") Integer id) {
        collectionMapper.deleteCollect(id);
    }
}

