package com.czq.offline.controller;

import com.czq.offline.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


//@Api(value="用户controller",tags={"用户操作接口"})
//@RequestMapping(value = "user")
@RestController
@RequestMapping(value = "/user", produces =  MediaType.APPLICATION_JSON_VALUE)
@Api(value = "用户信息查询", description = "用户基本信息操作API", tags = "UserController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    /*static Map<String, User> userMap = Collections.synchronizedMap(new HashMap<String, User>());

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUsers(){
        return new ArrayList<User>(conMap.values());
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        // 也可以用@ModelAttribute绑定参数，还可以通过@RequestParam从页面中传递参数
        conMap.put(user.getId(),user);
    }*/

    @ApiOperation(value = "/getUser", notes = "根据姓名查询用户信息")
    @RequestMapping(value = "getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser(@RequestParam("name") String name){
        User user = new User();
        user.setId("123");
        user.setName(name);
        user.setAge(25);
        return user;
    }
    @ApiOperation(value = "/addUser", notes = "添加一个用户")
    @RequestMapping(value = "addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User addUser(@RequestBody User user){
        return user;
    }

}
