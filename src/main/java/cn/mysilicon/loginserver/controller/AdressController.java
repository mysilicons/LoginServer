package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.Address;
import cn.mysilicon.loginserver.mapper.AddressMapper;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AdressController {
    @Resource
    AddressMapper addressMapper;

    @RequestMapping("/get")
    public String getAddress(@Param("user") Integer uid) {
        List<Address> addressesList = addressMapper.getAddressById(uid);
        Gson gson = new Gson();
        String addressJson = gson.toJson(addressesList);
        return addressJson;
    }

    @PostMapping("/add")
    public void AdressController(@RequestBody Address address) {
        addressMapper.insertAddress(address);
    }
}
