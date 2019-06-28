package com.cskaoyan.controller;

import com.cskaoyan.bean.Sys_user;
import com.cskaoyan.service.UserService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping()
public class SysController {
    @Autowired
    UserService userService;

    @RequestMapping("user/find")
    public String find(){
        return "/WEB-INF/jsp/user_list.jsp";
    }

    @RequestMapping("user/list")
    @ResponseBody
    public PageVo list(int page, int rows){
        PageVo pagevo = userService.getPage(page, rows);
        return pagevo;
    }

    @RequestMapping("user/edit")
    public String edit(){
        return "/WEB-INF/jsp/user_edit.jsp";
    }

    @RequestMapping("user/update_all")
    @ResponseBody
    public ResponseVo update(Sys_user user){
        ResponseVo responseVo = userService.updateUser(user);
        return responseVo;
    }

    @RequestMapping("user/add")
    public String add(){
        return "/WEB-INF/jsp/user_add.jsp";
    }

    @RequestMapping("user/insert")
    @ResponseBody
    public ResponseVo insert(Sys_user user){
        ResponseVo responseVo = userService.insertUser(user);
        return responseVo;
    }

    @RequestMapping("user/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = userService.batchDeleteUserByIds(Arrays.asList(ids));
        return responseVo;
    }


    @RequestMapping("user/*_judge")
    @ResponseBody
    public void judge(){
        //判断用户权限
    }

    @RequestMapping("role/get_data")
    @ResponseBody
    public List getData(){
        //角色管理此处暂时不写
        return null;
    }


}
