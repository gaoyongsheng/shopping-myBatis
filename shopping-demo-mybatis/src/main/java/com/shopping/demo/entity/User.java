package com.shopping.demo.entity;


import com.shopping.demo.dto.UserDto;
import com.shopping.demo.entity.base.BaseModel;
import lombok.Data;

/**
 * @Author Gao
 * @Date 2020/10/21 22:55
 * @Version 1.0
 */

@Data
public class User extends BaseModel<UserDto> {

    private Long id;

    private String userName;

    private String trueName;

    private String password;

    private String email;

    private String mobileNum;

    private String avatarAddress;

    private String sex;

    private String addTime;

    private String userRole;

    public User(){}

    public User(UserDto userDto){
        this.id = userDto.getId();
        this.userName = userDto.getUserName();
        this.trueName = userDto.getTrueName();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.mobileNum = userDto.getMobileNum();
        this.avatarAddress = userDto.getAvatarAddress();
        this.sex = userDto.getSex();
        this.addTime = userDto.getAddTime();
        this.userRole = userDto.getUserRole();

    }


    @Override
    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setUserName(userName);
        userDto.setTrueName(trueName);
        userDto.setPassword(password);
        userDto.setMobileNum(mobileNum);
        userDto.setAddTime(addTime);
        userDto.setAvatarAddress(avatarAddress);
        userDto.setEmail(email);
        userDto.setSex(sex);
        userDto.setUserRole(userRole);
        return userDto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id +
                ",userName='" + userName +
                ", trueName='" + trueName +
                ", password='" + password +
                ", email='" + email +
                ", mobileNum='" + mobileNum +
                ", avatarAddress='" + avatarAddress +
                ", sex='" + sex +
                ", addTime='" + addTime +
                ", userRole='" + userRole +
                '}';
    }
}
