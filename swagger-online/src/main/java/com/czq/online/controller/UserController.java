package com.czq.online.controller;

import com.czq.online.pojo.User;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.*;

// （不要深究实现的意义，只是为了演示不同的情况）

@RestController
@RequestMapping(value = "/user", produces =  MediaType.APPLICATION_JSON_VALUE)
@Api(value="用户controller",tags={"用户操作接口"})
// 下面注释的也可以使用，下面这个是为了演示 tags 可以写多个参数
//@Api(tags = {"UserController用户接口","UserController部门用户接口"},description = "用户基本信息操作")
public class UserController {

    private static Map<String, User> userMap = Collections.synchronizedMap(new HashMap<String, User>());

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUsers(){
        return new ArrayList<>(userMap.values());
    }

    /**
     * 新增一个用户
     * @param user 用户对象
     */
    @ApiOperation(value="创建用户" ,notes="创建用户时的注意事项")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, paramType = "body", dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        // 也可以用@ModelAttribute绑定参数，还可以通过@RequestParam从页面中传递参数
        userMap.put(user.getId(),user);
    }

    /**
     * 更新用户
     * @param userId 用户id
     * @param user 修改的用户对象
     */
    @ApiOperation(value="修改用户" ,notes="修改用户细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, paramType = "body", dataType = "User")
    })
    @RequestMapping(value = "/update/{userId}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable String userId , User user){
        // 也可以用@ModelAttribute绑定参数，还可以通过@RequestParam从页面中传递参数
        userMap.remove(userId);
        userMap.put(user.getId(),user);
    }

    /**
     * 根据姓名查询用户
     * @param name 用户姓名
     * @return 用户对象
     */
    @ApiOperation(value = "根据姓名查询用户", notes = "根据姓名查询用户信息")
    // 下面两种写法都可以
    @ApiParam(value = "用户的名字",name = "name",defaultValue = "zhangsan")
//    @ApiImplicitParam(name = "name", value = "用户的名字", paramType = "query", dataType = "String")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam(value = "name",required = false) String name){
        // 不要深究实现的内容，主要为了演示测试
        User user = new User();
        user.setId("1000");
        if(name != null) {
            user.setName(name);
        }else {
            user.setName("zhangsan");
        }
        user.setAge(26);
        return user;
    }

    /**
     * 添加用户
     * @param user 用户对象
     * @return 用户对象
     */
    @ApiIgnore() // 添加这个注解将不会显示在UI界面上
    @ApiOperation(value = "添加用户", notes = "添加一个用户")
    @RequestMapping(value = "addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser2(@RequestBody User user){
        return user;
    }

}
