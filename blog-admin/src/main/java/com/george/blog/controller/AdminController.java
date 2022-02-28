package com.george.blog.controller;

import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.PermissionPO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description 管理controller
 * @author georgeLin
 * @date 2022-02-27-22:18
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Resource
    private IPermissionService permissionService;

    @PostMapping("permission/permissionList")
    public ResultVO permissionList(@RequestBody PageDTO pageDTO){
        return permissionService.listPermission(pageDTO);
    }

    @PostMapping("permission/add")
    public ResultVO add(@RequestBody PermissionPO permission){
        return permissionService.add(permission);
    }

    @PostMapping("permission/update")
    public ResultVO update(@RequestBody PermissionPO permission){
        return permissionService.update(permission);
    }

    @GetMapping("permission/delete/{id}")
    public ResultVO delete(@PathVariable("id") Long id){
        return permissionService.delete(id);
    }
}
