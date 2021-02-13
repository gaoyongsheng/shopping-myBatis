package com.shopping.demo.entity;


import com.shopping.demo.dto.AddressDto;
import com.shopping.demo.entity.base.BaseModel;
import lombok.Data;

public class Address extends BaseModel<AddressDto> {

    private Long id;

    private String addrUser;

    private String addrMobile;

    private String addrProvince;

    private String addrCity;

    private String addrCounty;

    private String addrDetail;

    private Long addrUserId;

    public Address(){}

    public Address(AddressDto addressDto){
        this.id = addressDto.getId();
        this.addrUser = addressDto.getAddrUser();
        this.addrMobile = addressDto.getAddrMobile();
        this.addrProvince = addressDto.getAddrProvince();
        this.addrCity = addressDto.getAddrCity();
        this.addrCounty = addressDto.getAddrCounty();
        this.addrDetail = addressDto.getAddrDetail();
        this.addrUserId = addressDto.getAddrUserId();
    }

    @Override
    public AddressDto toDto() {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(id);
        addressDto.setAddrUser(addrUser);
        addressDto.setAddrMobile(addrMobile);
        addressDto.setAddrProvince(addrProvince);
        addressDto.setAddrCity(addrCity);
        addressDto.setAddrCounty(addrCounty);
        addressDto.setAddrDetail(addrDetail);
        return addressDto;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id='" + id +
                ",addrUser='" + addrUser +
                ", addrMobile='" + addrMobile +
                ", addrProvince='" + addrProvince +
                ", addrCity='" + addrCity +
                ", addrCounty='" + addrCounty +
                ", addrDetail='" + addrDetail +
                ", addrUserId='" + addrUserId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddrUser() {
        return addrUser;
    }

    public void setAddrUser(String addrUser) {
        this.addrUser = addrUser;
    }

    public String getAddrMobile() {
        return addrMobile;
    }

    public void setAddrMobile(String addrMobile) {
        this.addrMobile = addrMobile;
    }

    public String getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(String addrProvince) {
        this.addrProvince = addrProvince;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrCounty() {
        return addrCounty;
    }

    public void setAddrCounty(String addrCounty) {
        this.addrCounty = addrCounty;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public Long getAddrUserId() {
        return addrUserId;
    }

    public void setAddrUserId(Long addrUserId) {
        this.addrUserId = addrUserId;
    }
}
