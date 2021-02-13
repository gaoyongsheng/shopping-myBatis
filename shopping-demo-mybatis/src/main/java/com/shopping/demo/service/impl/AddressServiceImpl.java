package com.shopping.demo.service.impl;

import com.shopping.demo.constants.ShopExceptionCode;
import com.shopping.demo.dto.AddressDto;
import com.shopping.demo.entity.Address;
import com.shopping.demo.entity.User;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.mapper.AddressMapper;
import com.shopping.demo.service.AddressService;
import com.shopping.demo.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/2 11:31
 * @Version 1.0
 */

@Service
@Transactional
public class AddressServiceImpl extends AbstractBaseImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public void createAddress(AddressDto addressDto) {
        addressDto.setAddrUserId(((User) ThreadLocalUtils.get()).getId());
        addressMapper.insertAddress(new Address(addressDto));
    }

    @Override
    public List<Address> findAllAddress(Long UserId) {
        return addressMapper.getAddressByUserId(UserId);
    }

    @Override
    public Address findAddressById(Long id) {
        Address address = addressMapper.getAddressById(id);
        if(null == address){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"实体对象不存在");
        }
        return address;
    }

    @Override
    public boolean editAddress(AddressDto addressDto) {
        Address address = findAddressById(addressDto.getId());

        address.setAddrUser(addressDto.getAddrUser());
        address.setAddrMobile(addressDto.getAddrMobile());
        address.setAddrProvince(addressDto.getAddrProvince());
        address.setAddrCity(addressDto.getAddrCity());
        address.setAddrCounty(addressDto.getAddrCounty());
        address.setAddrDetail(addressDto.getAddrDetail());

        return addressMapper.updateAddress(address);

    }

    @Override
    public void deleteAddress(Long id) {
        if(null != findAddressById(id)){
            addressMapper.deleteAddress(id);
        }
    }


}
