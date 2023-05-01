package cn.mysilicon.loginserver.entity;

import lombok.Data;

@Data
public class Order {
    private int id;
    private long order_number;
    private int user_id;
    private int address_id;
    private int classification2_id;
    private String classification2_name;
    private int service_id;
    private String name;
    private String content;
    private String price;
    private String image;
    private String order_time;
    private String server_time;
    private String cur_status;
    private String username;
    private String phone;
    private String address;
}
