package cn.mysilicon.loginserver.entity;

import lombok.Data;

@Data
public class Merchant {
    private Integer id;
    private String name;
    private String password;
    private String token;
}
