package cn.mysilicon.loginserver.entity;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private Integer service_id;
    private Integer user_id;
    private Integer merchant_id;
    private String comment;
    private String time;
}
