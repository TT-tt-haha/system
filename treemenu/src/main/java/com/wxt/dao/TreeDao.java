package com.wxt.dao;

import com.wxt.entity.Node;
import com.wxt.entity.Tree;
import com.wxt.entity.TreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//import javax.swing.tree.TreeNode;

@Mapper
public interface TreeDao {
//    List<TreeNode> getTreeNodes();//查询所有树节点
    List<Tree> getAllNodes();
    Node getIds(Integer id);

    String findPreName(Integer  id);
    void addTree(TreeNode node);//添加树节点

    Integer findId(String menuName,Integer pId);

}
