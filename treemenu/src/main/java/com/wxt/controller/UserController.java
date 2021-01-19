package com.wxt.controller;

import com.wxt.entity.TreeNode;
import com.wxt.entity.User;
import com.wxt.entity.UserTemp;
import com.wxt.service.UserService;
import com.wxt.vo.Result;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{level}/{id}")
    @CrossOrigin
    public Map<String,Object> findAllById(@PathVariable Integer level, @PathVariable Integer id,
                                          Integer pageNow,Integer pageSize){
        System.out.println(pageNow);
        System.out.println(pageSize);
        Map<String ,Object> result = new HashMap<>();
        pageSize = (pageSize==null)?4:pageSize;
        pageNow = (pageNow==null)?1:(pageNow-1)*pageSize;
        List<UserTemp> users = new ArrayList<>();
        if(level==1){
            users = userService.findAllById1(id,pageNow,pageSize);
        }else if(level==2){
            users = userService.findAllById2(id,pageNow,pageSize);
        }else if(level==3){
            users = userService.findAllById3(id,pageNow,pageSize);
        }else if(level==4){
            users = userService.findAllById4(id,pageNow,pageSize);
        }else if(level==5){
            users = userService.findAllById5(id,pageNow,pageSize);
        }else {
            users = userService.findAllById6(id,pageNow,pageSize);
        }
        Integer totals = userService.findTotals();
        result.put("users",users);
        result.put("total",totals);
        return result;
    }

    @RequestMapping("/user/save/{pId}")
    @CrossOrigin
    public Result save(@PathVariable("pId") Integer pId,@RequestParam("uName") String uName,@RequestParam("uNum") String uNum,@RequestParam("uTele") String uTele,
                       TreeNode node,@RequestParam("menuName") String menuName){
//        System.out.println("uId:"+uId);
        User user = new User();
//        System.out.println(node.getPId());
        Result result = new Result();
        try {
            userService.save(pId,uName,uNum,uTele,node,menuName);
            result.setMsg("保存用户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("保存用户失败，请重试！");
        }
        return result;
    }
//    @RequestMapping("/update")

//    @RequestMapping("/save")
//    @CrossOrigin
//    public Result saveuser(User user,Tr)



    @RequestMapping("/user/delete")
    @CrossOrigin
    public Result delete(Integer id){
        Result result = new Result();
        try {
            userService.delete(id);
            result.setMsg("用户删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("删除用户失败，请重试！");
        }
        return result;
    }

    @RequestMapping("/export")
    @CrossOrigin
    public void exportController(HttpServletResponse response) throws IOException {
        Integer totals = userService.findTotals();
        System.out.println("totals:"+totals);
        List<UserTemp> users = userService.findAllById1(1001, 0,totals);
        String fileName = "users" + ".xls";
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet();
        //创建一个行
        Row row = sheet.createRow(0);
        row.setHeight((short) (22.50 * 20));
        int rowNum = 1;
        String [] headers = {"uid","uname","unum","utele","umenuName"};//数据库的字段名称
        for (int i = 0;i<headers.length;i++){
            Cell cell = row.createCell((short) i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //向Excel表中填充内容
        for (UserTemp user : users) {
            Row row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(user.getUId());
            row1.createCell((short) 1).setCellValue(user.getUName());
            row1.createCell((short) 2).setCellValue(user.getUNum());
            row1.createCell((short) 3).setCellValue(user.getUTele());
            row1.createCell((short) 4).setCellValue(user.getUMenuName());
            rowNum++;
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
//        return "redirect:/getUsersByLimit";
    }
}
