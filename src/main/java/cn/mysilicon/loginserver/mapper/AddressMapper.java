package cn.mysilicon.loginserver.mapper;

import cn.mysilicon.loginserver.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface AddressMapper {
    @Update("insert into user_address values(default,#{user_id},#{uname},#{phone},#{address})")
    @Transactional
    void insertAddress(Address address);

    @Select("select * from user_address where user_id=#{user_id}")
    @Transactional
    List<Address> getAddressById(int user_id);
}
