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

    public void save(Integer pId,String uName, String uNum, String uTele, TreeNode node, String menuName){
        User user = new User();
//        System.out.println("uNum====="+uNum);
//        System.out.println("id===="+userDao.selectByNum(uNum));
        String preName = treeDao.findPreName(pId);
//        System.out.println("preName===="+preName);
        node.setMenuName(menuName);
        node.setPreName(preName);
        node.setLevel(6);
        if(userDao.selectByNum(uNum)==null){
            System.out.println("执行添加！");
            user.setUName(uName);
            user.setUNum(uNum);
            user.setUTele(uTele);
//            String preName = treeDao.findPreName(node.getPId());
//            node.setMenuName(menuName);
////        System.out.println(preName);
//            node.setPreName(preName);
//            node.setLevel(6);
            treeDao.addTree(node);
            Node ids = treeDao.getIds(node.getMenuId());
            user.setQingzhouId(ids.getT1Id());
            user.setOfficeId(ids.getT2Id());
            user.setCommunityId(ids.getT3Id());
            user.setBuildingId(ids.getT4Id());
            user.setUnitId(ids.getT5Id());
            user.setLocationId(ids.getT6Id());
            userDao.save(user);
        }else {
            System.out.println("执行更新！");
            user.setUName(uName);
            user.setUNum(uNum);
            user.setUTele(uTele);
            System.out.println("pId2===="+pId);
            System.out.println("menuName===="+menuName);
            Integer id = treeDao.findId(menuName, pId);
            System.out.println("menuId===="+id);
            Node ids = treeDao.getIds(id);
            user.setUId(userDao.selectByNum(uNum));
            user.setQingzhouId(ids.getT1Id());
            user.setOfficeId(ids.getT2Id());
            user.setCommunityId(ids.getT3Id());
            user.setBuildingId(ids.getT4Id());
            user.setUnitId(ids.getT5Id());
            user.setLocationId(ids.getT6Id());
            userDao.update(user);
            System.out.println("uid===="+user.getUId());
            System.out.println("tele===="+user.getUTele());
        }



    }

//    public void update(User user,TreeNode node){
//        Node ids = treeDao.getIds(node.getMenuId());
//        user.setQingzhouId(ids.getT1Id());
//        user.setOfficeId(ids.getT2Id());
//        user.setCommunityId(ids.getT3Id());
//        user.setBuildingId(ids.getT4Id());
//        user.setUnitId(ids.getT5Id());
//        user.setLocationId(ids.getT6Id());
//        userDao.update(user);
//
//    }

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