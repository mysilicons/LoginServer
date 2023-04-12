package cn.mysilicon.loginserver.entity;

import lombok.Data;

@Data
public class Detail {
    private Integer id;
    private String image_url;
    private String title;
    private String content;
    private String price;
}
