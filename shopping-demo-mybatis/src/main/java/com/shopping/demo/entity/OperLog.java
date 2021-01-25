package com.shopping.demo.entity;


import com.shopping.demo.constants.DaoConstant;
import com.shopping.demo.dto.OperLogDto;
import com.shopping.demo.entity.base.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = DaoConstant.OPER_LOG_TABLE_NAME)
@Data
public class OperLog extends BaseModel<OperLogDto> {

  @Column(name = DaoConstant.OPER_LOG_USER_ID)
  private Long userId;

  @Column(name = DaoConstant.OPER_LOG_USERNAME)
  private String userName;

  @Column(name = DaoConstant.OPER_LOG_TRUE_NAME)
  private String trueName;

  @Column(name = DaoConstant.OPER_LOG_MOBILE_NUM)
  private String mobileNum;

  @Column(name = DaoConstant.OPER_LOG_API_INTERFACE)
  private String apiInterface;

  @Column(name = DaoConstant.OPER_LOG_API_DESCRIPTION)
  private String apiDescription;

  @Column(name = DaoConstant.OPER_LOG_REQ_DATA)
  private String reqData;

  @Column(name = DaoConstant.OPER_LOG_RET_CODE)
  private String retCode;

  @Column(name = DaoConstant.OPER_LOG_REQ_TIME)
  private String reqTime;

  public OperLog(){}

  public OperLog(OperLogDto operLogDto){
    this.id = operLogDto.getId();
    this.userId = operLogDto.getUserId();
    this.userName = operLogDto.getUsername();
    this.trueName = operLogDto.getTrueName();
    this.mobileNum = operLogDto.getMobileNum();
    this.apiInterface = operLogDto.getApiInterface();
    this.apiDescription = operLogDto.getApiDescription();
    this.reqData = operLogDto.getReqData();
    this.retCode = operLogDto.getRetCode();
    this.reqTime = operLogDto.getReqTime();
  }

  @Override
  public Object toDto() {
    OperLogDto operLogDto = new OperLogDto();
    operLogDto.setId(id);
    operLogDto.setApiDescription(apiDescription);
    operLogDto.setApiInterface(apiInterface);
    operLogDto.setId(id);
    operLogDto.setMobileNum(mobileNum);
    operLogDto.setReqData(reqData);
    operLogDto.setReqTime(reqTime);
    operLogDto.setRetCode(retCode);
    operLogDto.setTrueName(trueName);
    operLogDto.setUserId(userId);
    operLogDto.setUsername(userName);
    return operLogDto;
  }

  @Override
  public String toString() {
    return "OperLog{" +
            "userId=" + userId +
            ", userName='" + userName +
            ", trueName='" + trueName +
            ", mobileNum='" + mobileNum +
            ", apiInterface='" + apiInterface +
            ", apiDescription='" + apiDescription +
            ", reqData='" + reqData +
            ", retCode='" + retCode +
            ", reqTime='" + reqTime +
            ", id=" + id +
            '}';
  }
}
