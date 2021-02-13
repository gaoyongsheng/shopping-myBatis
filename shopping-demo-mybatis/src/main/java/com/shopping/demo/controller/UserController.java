package com.shopping.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.cro.UserEditCro;
import com.shopping.demo.cro.UserLoginCro;
import com.shopping.demo.cro.UserRegisteCro;
import com.shopping.demo.entity.User;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Gao
 * @Date 2020/10/22 0:31
 * @Version 1.0
 */

@RestController
@Slf4j
@RequestMapping("/service/v1")
public class UserController extends AbstractBaseCtrl {

    @Autowired
    UserService userService;

    @PostMapping("/user.register")
    public Object registerUser(@RequestBody UserRegisteCro userRegisteCro){
        userService.registerUser(userRegisteCro);
        return success("");
    }

    @PostMapping("/user.login")
    public Object userLogin(@RequestBody UserLoginCro userLoginCro){
        User user = userService.findUserByUserNameOrMobile(userLoginCro);
        return success(user);
    }

    @PostMapping("/user.edit")
    public Object editUser(@RequestBody UserEditCro userEditCro){
        return success(userService.editUser(userEditCro));
    }

//    @GetMapping("/user.findById")
//    public Object findUserById(@RequestParam(value = "id",defaultValue = "0") Long id){
//    @PathVariable("xxx")
//    通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
    @GetMapping("/user.findById/{id}")
    public Object findUserById(@PathVariable("id") Long id){
        User curUser = userService.findUserById(id);
        return success(curUser);
    }

    @GetMapping("/user.deleteById")
    public Object deleteUserById(@RequestParam("id") Long id){
        userService.deleteUserById(id);
        return success("");
    }

    @PostMapping("/user.findAllByPage")
    public Object findAllByPage(@RequestBody PageRequest pageQuery){
        return success(userService.findAllByPage(pageQuery));
    }

}
