package com.wxt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors
public class TreeNode {
    private Integer menuId;
    private String menuName;
    private Integer pId;
    private String preName;
    private Integer level;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode(Integer menuId, String menuName, Integer pId, String preName, Integer level) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.pId = pId;
        this.preName = preName;
        this.level = level;
    }
}
