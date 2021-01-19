package com.wxt;

import com.wxt.dao.TreeDao;
import com.wxt.dao.UserDao;
import com.wxt.entity.*;
import com.wxt.service.TreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class TreemenuApplicationTests {

    @Autowired
    private TreeService treeService;

    @Autowired
    private TreeDao treeDao;

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        Integer id = treeDao.findId("东1箱低1表室6", 1003);
        System.out.println(id);


//        List<Tree> nodes = treeDao.getAllNodes();
//        for (Tree node : nodes) {
//            System.out.println(node);
//        }
    }

}
