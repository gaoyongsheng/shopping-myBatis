package com.shopping.demo.service;

import com.github.pagehelper.PageInfo;
import com.shopping.demo.cro.*;
import com.shopping.demo.entity.User;

import java.util.List;


/**
 * @Author Gao
 * @Date 2020/10/22 0:31
 * @Version 1.0
 */
public interface UserService {

    /**
     * 注册用户
     * */
    void registerUser(UserRegisteCro userRegisteCro);

    /**
     * 通过手机号查找用户
     * */
    User findUserByMobile(String mobileNum);

    /**
     * 通过用户名查找用户
     * */
    User findUserByUserName(String userName);

    /**
     * 通过id查找用户
     * */
    User findUserById(Long id);

    /**
     * 编辑用户
     * */
    boolean editUser(UserEditCro userEditCro);

    /**
     * 通过用户名或者手机号查询用户
     * */
    User findUserByUserNameOrMobile(UserLoginCro userLoginCro);

    User findCurUserByUserNameOrMobile(String str);

    /**
     * 通过Id删除用户
     * */
    void deleteUserById(Long id);

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findAllByPage(PageRequest pageRequest);

}
