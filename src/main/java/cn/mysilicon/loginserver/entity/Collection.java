package cn.mysilicon.loginserver.entity;


import lombok.Data;

@Data
public class Collection {
    private int id;
    private int user_id;
    private int classification2_id;
    private String classification2_name;
    private int service_id;
    private String name;
    private String price;
    private String image;
}