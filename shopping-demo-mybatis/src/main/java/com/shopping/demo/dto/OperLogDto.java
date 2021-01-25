package com.shopping.demo.dto;

import com.shopping.demo.dto.base.BaseDto;

public class OperLogDto extends BaseDto {


  private Long id;
  private Long userId;
  private String username;
  private String trueName;
  private String mobileNum;
  private String apiInterface;
  private String apiDescription;
  private String reqData;
  private String retCode;
  private String reqTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getTrueName() {
    return trueName;
  }

  public void setTrueName(String trueName) {
    this.trueName = trueName;
  }

  public String getMobileNum() {
    return mobileNum;
  }

  public void setMobileNum(String mobileNum) {
    this.mobileNum = mobileNum;
  }

  public String getApiInterface() {
    return apiInterface;
  }

  public void setApiInterface(String apiInterface) {
    this.apiInterface = apiInterface;
  }

  public String getApiDescription() {
    return apiDescription;
  }

  public void setApiDescription(String apiDescription) {
    this.apiDescription = apiDescription;
  }

  public String getReqData() {
    return reqData;
  }

  public void setReqData(String reqData) {
    this.reqData = reqData;
  }

  public String getRetCode() {
    return retCode;
  }

  public void setRetCode(String retCode) {
    this.retCode = retCode;
  }

  public String getReqTime() {
    return reqTime;
  }

  public void setReqTime(String reqTime) {
    this.reqTime = reqTime;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((apiDescription == null) ? 0 : apiDescription.hashCode());
    result = prime * result + ((apiInterface == null) ? 0 : apiInterface.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((mobileNum == null) ? 0 : mobileNum.hashCode());
    result = prime * result + ((reqData == null) ? 0 : reqData.hashCode());
    result = prime * result + ((reqTime == null) ? 0 : reqTime.hashCode());
    result = prime * result + ((retCode == null) ? 0 : retCode.hashCode());
    result = prime * result + ((trueName == null) ? 0 : trueName.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OperLogDto other = (OperLogDto) obj;
    if (apiDescription == null) {
      if (other.apiDescription != null)
        return false;
    } else if (!apiDescription.equals(other.apiDescription))
      return false;
    if (apiInterface == null) {
      if (other.apiInterface != null)
        return false;
    } else if (!apiInterface.equals(other.apiInterface))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (mobileNum == null) {
      if (other.mobileNum != null)
        return false;
    } else if (!mobileNum.equals(other.mobileNum))
      return false;
    if (reqData == null) {
      if (other.reqData != null)
        return false;
    } else if (!reqData.equals(other.reqData))
      return false;
    if (reqTime == null) {
      if (other.reqTime != null)
        return false;
    } else if (!reqTime.equals(other.reqTime))
      return false;
    if (retCode == null) {
      if (other.retCode != null)
        return false;
    } else if (!retCode.equals(other.retCode))
      return false;
    if (trueName == null) {
      if (other.trueName != null)
        return false;
    } else if (!trueName.equals(other.trueName))
      return false;
    if (userId == null) {
      if (other.userId != null)
        return false;
    } else if (!userId.equals(other.userId))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "OperLogDto [id=" + id
        + ", username=" + username + ", trueName=" + trueName + ", mobileNum=" + mobileNum + ", apiInterface="
        + apiInterface + ", apiDescription=" + apiDescription + ", reqData=" + reqData + ", retCode=" + retCode
        + ", reqTime=" + reqTime + "]";
  }

}
