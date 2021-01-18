package com.wxt;

import com.wxt.dao.TreeDao;
import com.wxt.dao.UserDao;
import com.wxt.entity.Node;
import com.wxt.entity.Tree;
import com.wxt.entity.TreeNode;
import com.wxt.entity.UserTemp;
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
        List<UserTemp> all = userDao.findAllById1(1001, 1, 4);
        for (UserTemp temp : all) {
            System.out.println(temp);
        }

//        List<Tree> nodes = treeDao.getAllNodes();
//        for (Tree node : nodes) {
//            System.out.println(node);
//        }
    }

}
