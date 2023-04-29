package cn.mysilicon.loginserver.entity;

import lombok.Data;

import java.util.List;

@Data
public class CollectionData {
    private int classification2_id;
    private String classification2_name;
    private List<Collection> collectionList;

}
