package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.Detail;
import cn.mysilicon.loginserver.entity.Service;
import cn.mysilicon.loginserver.mapper.ServiceMapper;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Resource
    private ServiceMapper serviceMapper;


    @RequestMapping("/classification2")
    public String getServiceList(@Param("classification2") Integer classification2) {
        List<Service> classification2List = serviceMapper.selectByClassification2(classification2);
        Gson gson = new Gson();
        return gson.toJson(classification2List);
    }

    @RequestMapping("/classification1")
    public String getServiceClassification1(@Param("classification1") Integer classification1) {
        List<Service> classification1List = serviceMapper.selectByclassification1(classification1);
        Gson gson = new Gson();
        return gson.toJson(classification1List);
    }

    @RequestMapping("/detail")
    public String getServiceDetail(@Param("id") Integer id) {
        Detail detail = serviceMapper.selectById(id);
        Gson gson = new Gson();
        return gson.toJson(detail);
    }

    @GetMapping("/list")
    public String getAllService() {
        List<Service> serviceList = serviceMapper.selectAll();
        Gson gson = new Gson();
        return gson.toJson(serviceList);
    }
}
