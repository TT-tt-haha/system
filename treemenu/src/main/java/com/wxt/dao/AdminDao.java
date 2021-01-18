package com.wxt.dao;

import com.wxt.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {

    Admin findByNameAndPassword(String username,String password);
}
