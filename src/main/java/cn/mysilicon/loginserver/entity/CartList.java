package cn.mysilicon.loginserver.entity;


import lombok.Data;

@Data

public class CartList {
    private int id;
    private int shop_id;
    private String shop_name;
    private int product_id;
    private String product_name;
    private String price;
    private String default_pic;

    // getter and setter methods
}