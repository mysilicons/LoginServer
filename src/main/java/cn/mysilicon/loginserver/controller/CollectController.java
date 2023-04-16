package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.ShopData;
import cn.mysilicon.loginserver.mapper.CollectionMapper;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class CollectController {
    @Resource
    private CollectionMapper collectionMapper;

    @GetMapping("/orders")
    public String getOrders() {
        List<ShopData> shopDataList = collectionMapper.selectAll();
        for (int i = shopDataList.size() - 1; i >= 0; i--) {
            if (shopDataList.get(i).getCartlist().size() == 0)
                shopDataList.remove(i);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("orderData", shopDataList);
        String json = new JSONObject(resultMap).toJSONString();
        return json;
    }

    @PostMapping("/orders/add")
    public void addCollect(@Param("id") Integer id) {
        collectionMapper.addCollect(id);
    }

}

