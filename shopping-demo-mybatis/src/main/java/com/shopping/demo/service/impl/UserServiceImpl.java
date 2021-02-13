package com.shopping.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.demo.constants.ShopExceptionCode;
import com.shopping.demo.cro.*;
import com.shopping.demo.dto.UserDto;
import com.shopping.demo.entity.User;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.mapper.UserMapper;
import com.shopping.demo.service.UserService;
import com.shopping.demo.utils.DateTimeUtils;
import com.shopping.demo.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends AbstractBaseImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public void registerUser(UserRegisteCro userRegisteCro) throws MyShopException {

        User curUser = userMapper.getUserByMobileNum(userRegisteCro.getMobileNum());
        if(curUser != null){
            throw new MyShopException(ShopExceptionCode.USER_ALREADY_EXISTS,"用户已存在");
        }
        UserDto userDto = userRegisteCro.toDto();
        LOG.info("************getSysCurDate*********[{}]",DateTimeUtils.getSysCurDate());
        userDto.setAddTime(DateTimeUtils.getSysCurDate());
        userMapper.insertUser(new User(userDto));
    }

    @Override
    public User findUserByMobile(String mobileNum) {
        User curUser = userMapper.getUserByMobileNum(mobileNum);
        if(curUser == null){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"实体对象不存在");
        }
        return curUser;
    }

    @Override
    public User findUserByUserName(String userName) {
        User curUser = userMapper.getUserByUserName(userName);
        if(curUser == null){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"实体对象不存在");
        }
        return curUser;
    }

    @Override
    public User findUserById(Long id) {
        User user = userMapper.getUserById(id);
        if(null == user){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在");
        }
        return user;
    }

    @Override
    public boolean editUser(UserEditCro userEditCro) {
        return userMapper.updateUser(new User(userEditCro.toDto()));
    }

    @Override
    public void deleteUserById(Long id) {
        if(null == findUserById(id)){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在");
        }
        userMapper.deleteUser(id);
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult findAllByPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.getUsersByPage();
        return getPageResult(pageRequest,new PageInfo<User>(users));
    }

    @Override
    public User findUserByUserNameOrMobile(UserLoginCro userLoginCro) {
        String str = userLoginCro.getUserName();
        if(Util.checkIsPhone(str)){   // 是手机号
            User curUser1 = userMapper.getUserByMobileNum(userLoginCro.getUserName());
            if(null == curUser1){
                throw new MyShopException(ShopExceptionCode.MOBILE_NO_REGIST,"该手机号未被注册"); // 该手机号未被注册
            } else {
                return curUser1;
            }
        } else {
            User curUser2 = userMapper.getUserByUserName(userLoginCro.getUserName());
            if(null == curUser2){
                throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在"); // 用户不存在
            } else {
                return curUser2;
            }
        }
    }

    @Override
    public User findCurUserByUserNameOrMobile(String str) {
        if(Util.checkIsPhone(str)){   // 是手机号
            User curUser1 = userMapper.getUserByMobileNum(str);
            if(null == curUser1){
                throw new MyShopException(ShopExceptionCode.MOBILE_NO_REGIST,"该手机号未被注册"); // 该手机号未被注册
            } else {
                return curUser1;
            }
        } else {
            User curUser2 = userMapper.getUserByUserName(str);
            if(null == curUser2){
                throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在"); // 用户不存在
            } else {
                return curUser2;
            }
        }
    }


}
