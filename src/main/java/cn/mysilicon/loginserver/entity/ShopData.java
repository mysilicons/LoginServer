package cn.mysilicon.loginserver.entity;

import lombok.Data;

import java.util.List;

@Data
public class ShopData {
    private int shopId;
    private String shopName;
    private List<CartList> cartlist;

}
