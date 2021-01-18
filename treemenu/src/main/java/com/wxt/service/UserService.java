package com.wxt.service;

import com.wxt.dao.TreeDao;
import com.wxt.dao.UserDao;
import com.wxt.entity.Node;
import com.wxt.entity.TreeNode;
import com.wxt.entity.User;
import com.wxt.entity.UserTemp;
import com.wxt.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TreeDao treeDao;

    public List<UserTemp> findAllById1(Integer id, Integer pageNow, Integer rows ){
        return userDao.findAllById1(id,pageNow,rows);
    }
    public List<UserTemp> findAllById2(Integer id,Integer pageNow,Integer rows ){
        return userDao.findAllById2(id,pageNow,rows);
    }
    public List<UserTemp> findAllById3(Integer id,Integer pageNow,Integer rows ){
        return userDao.findAllById3(id,pageNow,rows);
    }
    public List<UserTemp> findAllById4(Integer id,Integer pageNow,Integer rows ){
        return userDao.findAllById4(id,pageNow,rows);
    }
    public List<UserTemp> findAllById5(Integer id,Integer pageNow,Integer rows ){
        return userDao.findAllById5(id,pageNow,rows);
    }
    public List<UserTemp> findAllById6(Integer id,Integer pageNow,Integer rows ){
        return userDao.findAllById6(id,pageNow,rows);
    }

    public void save(Integer id,String uName, String uNum, String uTele, TreeNode node, String menuName){
        User user = new User();
        System.out.println("id===="+user.getUId());
        user.setUName(uName);
        user.setUNum(uNum);
        user.setUTele(uTele);
        String preName = treeDao.findPreName(node.getPId());
        node.setMenuName(menuName);
        System.out.println(preName);
        node.setPreName(preName);
        node.setLevel(6);
        treeDao.addTree(node);
        System.out.println(node);
//        Integer id = treeDao.findId(menu);
        System.out.println(node.getMenuId());
        Node ids = treeDao.getIds(node.getMenuId());
//        List<Integer> ids = treeDao.getIds(node.getMenuId());
        System.out.println(ids);
        user.setQingzhouId(ids.getT1Id());
        user.setOfficeId(ids.getT2Id());
        user.setCommunityId(ids.getT3Id());
        user.setBuildingId(ids.getT4Id());
        user.setUnitId(ids.getT5Id());
        user.setLocationId(ids.getT6Id());
        if(id==null){
            userDao.save(user);
        }else {
            System.out.println("执行更新");
            userDao.update(user);
        }

    }

    public void delete(Integer id) {
        userDao.delete(id);
    }


//    public List<User> findByPage(Integer pageNow, Integer rows) {
//        int start = (pageNow-1)*rows;
//        return userDao.findByPage(start,rows);
//    }

    public Integer findTotals() {
        return userDao.findTotals();
    }
}