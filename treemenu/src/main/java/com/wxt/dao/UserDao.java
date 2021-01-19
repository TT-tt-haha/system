package com.wxt.dao;

import com.wxt.entity.User;
import com.wxt.entity.UserTemp;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserDao {
    List<UserTemp> findAllById1(Integer id, Integer pageNow, Integer pageSize );
    List<UserTemp> findAllById2(Integer id,Integer pageNow,Integer pageSize );
    List<UserTemp> findAllById3(Integer id,Integer pageNow,Integer pageSize );
    List<UserTemp> findAllById4(Integer id,Integer pageNow,Integer pageSize );
    List<UserTemp> findAllById5(Integer id,Integer pageNow,Integer pageSize );
    List<UserTemp> findAllById6(Integer id,Integer pageNow,Integer pageSize );

    //保存用户信息
    void save(User user);
    //根据id删除一个用户
    void delete(Integer id);
    //修改用户信息
    void update(User user);

    Integer selectByNum(String nNum);

    //分页查询
//    List<User> findByPage(Integer pageNow,Integer rows );
    //查询总条数
    Integer findTotals();
}