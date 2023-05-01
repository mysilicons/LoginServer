package cn.mysilicon.loginserver.entity;

import lombok.Data;

@Data
public class Service {
    private Integer id;
    private Integer classification1;
    private Integer classification2;
    private String image_url;
    private String title;
    private String content;
    private String price;
    private String city;
    private Integer merchant_id;
}
