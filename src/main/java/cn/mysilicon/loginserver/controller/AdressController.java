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

    @RequestMapping("/list")
    public String getAddress(@Param("user") Integer uid) {
        List<Address> addressesList = addressMapper.getAddressById(uid);
        Gson gson = new Gson();
        return gson.toJson(addressesList);
    }

    @RequestMapping("/get")
    public String getAddressById(@Param("id") Integer id) {
        Address address = addressMapper.getAddressByAddressId(id);
        Gson gson = new Gson();
        return gson.toJson(address);
    }

    @PostMapping("/add")
    public void addAddress(@RequestBody Address address) {
        addressMapper.insertAddress(address);
    }

    @PostMapping("/edit")
    public void editAddress(@RequestBody Address address) {
        addressMapper.editAddress(address);
    }

    @PostMapping("/delete")
    public void deleteAddress(@Param("id") Integer id) {
        addressMapper.deleteAddress(id);
    }
}
