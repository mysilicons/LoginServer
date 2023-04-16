package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.Detail;
import cn.mysilicon.loginserver.entity.ServiceList;
import cn.mysilicon.loginserver.mapper.ServiceListMapper;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceListController {

    @Resource
    private ServiceListMapper serviceListMapper;


    @RequestMapping("/service")
    public String getServiceList(@Param("classification") String classification){
        List<ServiceList> serviceList = serviceListMapper.selectByClassification(classification);
        Gson gson = new Gson();
        String result = gson.toJson(serviceList);
        return result;
    }

    @RequestMapping("/service/detail")
    public String getServiceDetail(@Param("id") Integer id) {
        List<Detail> detailList = serviceListMapper.selectById(id);
        Gson gson = new Gson();
        String result = gson.toJson(detailList);
        return result;
    }

    @GetMapping("/service/all")
    public String getAllService() {
        List<ServiceList> serviceList = serviceListMapper.selectAll();
        Gson gson = new Gson();
        String result = gson.toJson(serviceList);
        return result;
    }
}
