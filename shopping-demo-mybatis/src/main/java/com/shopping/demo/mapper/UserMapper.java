package com.shopping.demo.mapper;

import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author Gao
 * @Date 2020/10/22 0:27
 * @Version 1.0
 */

@Repository
public interface UserMapper {

    // 新增用户
    Long insertUser(User user);

    // 更新用户信息
    boolean updateUser(User user);

    // 删除用户信息
    void deleteUser(Long id);

    // 通过id查询用户信息
    User getUserById(Long id);

    // 通过手机号查询用户信息
    User getUserByMobileNum(String mobileNum);

    // 通过用户名查询用户信息
    User getUserByUserName(String userName);

    // 分页查询用户信息
    List<User> getUsersByPage();

}
