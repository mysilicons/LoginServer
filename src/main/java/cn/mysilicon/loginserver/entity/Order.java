package cn.mysilicon.loginserver.entity;

import lombok.Data;

@Data
public class Order {
    private int id;
    private int shop_id;
    private String shop_name;
    private int product_id;
    private String title;
    private String content;
    private String price;
    private String image_url;
    private String order_time;
    private String cur_status;
}
