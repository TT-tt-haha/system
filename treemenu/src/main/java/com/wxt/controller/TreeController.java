package com.wxt.controller;

import com.wxt.entity.TreeNode;
import com.wxt.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("treedata")
    @CrossOrigin
    public List<TreeNode> getTree(){
        return treeService.getTree();
    }
}
