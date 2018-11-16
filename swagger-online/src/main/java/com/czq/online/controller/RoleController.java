package com.czq.online.controller;

import com.czq.online.pojo.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api( tags = "RoleController",description = "角色基本信息操作")
@RequestMapping("role")
@RestController
public class RoleController {

    static Map<String, Role> roleMap = Collections.synchronizedMap(new HashMap<String, Role>());

    @ApiOperation(value="获角色列表",notes="获角色列表信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Role> getRoles(){
        return new ArrayList<>(roleMap.values());
    }

    @ApiOperation(value="创建角色", notes="根据Role对象创建用户")
    @ApiImplicitParam(name = "role", value = "角色详细实体role", required = true, dataType = "Role")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addRole(@ModelAttribute Role role){
        roleMap.put(role.getId(),role);
    }

}
