package com.wxt.controller;

import com.wxt.dao.AdminDao;
import com.wxt.entity.Admin;
import com.wxt.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminDao adminDao;

    @CrossOrigin
    @RequestMapping("/api/login")
    @ResponseBody
    public Result login(String username,String password, HttpSession session) {
        Result result = new Result();
        System.out.println(username);

        username = HtmlUtils.htmlEscape(username);
        Admin admin = adminDao.findByNameAndPassword(username, password);

//        User user = userService.get(username, requestUser.getPassword());
        if (null == admin) {
            result.setStatus(false);
            result.setMsg("没有权限登陆！");
        } else {
            session.setAttribute("user", admin);
            result.setMsg("有权限登陆");
        }
        System.out.println(result.getMsg());
        return result;
    }
}
