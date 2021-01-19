package com.wxt.service;

import com.wxt.dao.TreeDao;
import com.wxt.entity.Tree;
import com.wxt.entity.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreeService {
    @Autowired
    private TreeDao treeDao;

    public List<TreeNode> getTree(){
        List<Tree> nodes = treeDao.getAllNodes();
        System.out.println(nodes.size());
        Map<String, TreeNode> map = new HashMap<>();
        Map<String, TreeNode> map2 = new HashMap<>();

        List<TreeNode> parents = new ArrayList<>();
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode2 = new TreeNode();
        TreeNode treeNode3 = new TreeNode();
        TreeNode treeNode4 = new TreeNode();
        TreeNode treeNode5 = new TreeNode();
        TreeNode treeNode6 = new TreeNode();
//        System.out.println(treeNode1);
//        TreeNode parent = new TreeNode();
        for (Tree menu : nodes) {
//            System.out.println(menu);
            if(menu.getT1Id()!=null &&!map.containsKey(menu.getT1Id()+menu.getT1Name())){
                treeNode1 = new TreeNode(menu.getT1Id(),menu.getT1Name(),menu.getT1Pid(),null,1);
                map.put(menu.getT1Id()+treeNode1.getMenuName(),treeNode1);
                if(treeNode1.getPId()==null&&!parents.contains(treeNode1)) {
//                    System.out.println("==");
                    parents.add(treeNode1);
                }
            }
            if(menu.getT2Id()!=null&&!map.containsKey(menu.getT2Id()+menu.getT2Name())){
                treeNode2 = new TreeNode(menu.getT2Id(),menu.getT2Name(),menu.getT2Pid(),treeNode1.getMenuName(),2);
                map.put(menu.getT2Id()+treeNode2.getMenuName(),treeNode2);
            }
            if(menu.getT3Id()!=null&&!map.containsKey(menu.getT3Id()+menu.getT3Name())){
                treeNode3 = new TreeNode(menu.getT3Id(),menu.getT3Name(),menu.getT3Pid(),treeNode2.getMenuName(),3);
                map.put(menu.getT3Id()+treeNode3.getMenuName(),treeNode3);
            }
            if(menu.getT4Id()!=null&&!map.containsKey(menu.getT4Id()+menu.getT4Name())){
                treeNode4 = new TreeNode(menu.getT4Id(),menu.getT4Name(),menu.getT4Pid(),treeNode3.getMenuName(),4);
                map.put(menu.getT4Id()+treeNode4.getMenuName(),treeNode4);
            }
            if(menu.getT5Id()!=null&&!map.containsKey(menu.getT5Id()+menu.getT5Name())){
                treeNode5 = new TreeNode(menu.getT5Id(),menu.getT5Name(),menu.getT5Pid(),treeNode4.getMenuName(),5);
                map.put(menu.getT5Id()+treeNode5.getMenuName(),treeNode5);
            }

            if(menu.getT6Id()!=null&&!map.containsKey(menu.getT6Id()+menu.getT6Name())){
                treeNode6 = new TreeNode(menu.getT6Id(),menu.getT6Name(),menu.getT6Pid(),treeNode5.getMenuName(),6);
                map.put(menu.getT6Id()+treeNode6.getMenuName(),treeNode6);
            }
        }
//        System.out.println(map);
        for (Tree menu : nodes) {
//
            if(menu.getT1Id()!=null&&!map2.containsKey(menu.getT1Id()+menu.getT1Name())){
                treeNode1 = new TreeNode(menu.getT1Id(),menu.getT1Name(),menu.getT1Pid(),null,1);
                TreeNode parent = map.get(treeNode1.getPId()+treeNode1.getPreName());
                map2.put(menu.getT1Id()+treeNode1.getMenuName(),treeNode1);
                if(parent!=null){
                    parent.getChildren().add(treeNode2);
                }
            }
            if(menu.getT2Id()!=null&&!map2.containsKey(menu.getT2Id()+menu.getT2Name())){
                System.out.println("============="+menu.getT2Pid());
                treeNode2 = new TreeNode(menu.getT2Id(),menu.getT2Name(),menu.getT2Pid(),treeNode1.getMenuName(),2);
                TreeNode parent = map.get(treeNode2.getPId()+treeNode2.getPreName());
//                System.out.println("treeNode2:"+treeNode2);
//                System.out.println("编号"+treeNode2.getPId()+treeNode2.getPreName());
                map2.put(menu.getT2Id()+treeNode2.getMenuName(),treeNode2);
                if(parent!=null){
                    parent.getChildren().add(treeNode2);
                }
//                System.out.println("treeNode2:"+treeNode2);
//                System.out.println("parent2:"+parent);
            }
            if(menu.getT3Id()!=null&&!map2.containsKey(menu.getT3Id()+menu.getT3Name())){
                treeNode3 = new TreeNode(menu.getT3Id(),menu.getT3Name(),menu.getT3Pid(),treeNode2.getMenuName(),3);
                map2.put(menu.getT3Id()+treeNode3.getMenuName(),treeNode3);
                TreeNode parent = map.get(treeNode3.getPId()+treeNode3.getPreName());
                if(parent!=null){
//                    parent.getChildren().add(treeNode3);
                    treeNode2.getChildren().add(treeNode3);
                }
//                System.out.println("parent3:"+parent);
            }

            if(menu.getT4Id()!=null&&!map2.containsKey(menu.getT4Id()+menu.getT4Name())){
                treeNode4 = new TreeNode(menu.getT4Id(),menu.getT4Name(),menu.getT4Pid(),treeNode3.getMenuName(),4);
                map2.put(menu.getT4Id()+treeNode4.getMenuName(),treeNode4);
                TreeNode parent = map.get(treeNode4.getPId()+treeNode4.getPreName());
                if(parent!=null){
//                    parent.getChildren().add(treeNode4);
                    treeNode3.getChildren().add(treeNode4);
                }
//                System.out.println("parent4:"+parent);
            }

            if(menu.getT5Id()!=null&&!map2.containsKey(menu.getT5Id()+menu.getT5Name())){
                treeNode5 = new TreeNode(menu.getT5Id(),menu.getT5Name(),menu.getT5Pid(),treeNode4.getMenuName(),5);
                map2.put(menu.getT5Id()+treeNode5.getMenuName(),treeNode5);
                System.out.println(treeNode5.getPId()+treeNode5.getPreName());
                TreeNode parent = map.get(treeNode5.getPId()+treeNode5.getPreName());
                if(parent!=null){
//                    parent.getChildren().add(treeNode5);
                    treeNode4.getChildren().add(treeNode5);
                }
            }


            if(menu.getT6Id()!=null&&!map2.containsKey(menu.getT6Id()+menu.getT6Name())){
                treeNode6 = new TreeNode(menu.getT6Id(),menu.getT6Name(),menu.getT6Pid(),treeNode5.getMenuName(),6);
                map2.put(menu.getT6Id()+treeNode6.getMenuName(),treeNode6);
                TreeNode parent = map.get(treeNode6.getPId()+treeNode6.getPreName());
                if(parent!=null){
//                    parent.getChildren().add(treeNode6);
                    treeNode5.getChildren().add(treeNode6);
                }
//                System.out.println("parent6:"+parent);
            }
//            System.out.println("parents:"+parents);
        }

        return parents;

    }
}

