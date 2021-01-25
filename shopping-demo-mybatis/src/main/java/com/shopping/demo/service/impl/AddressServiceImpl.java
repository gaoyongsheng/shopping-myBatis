package com.shopping.demo.service.impl;

import com.shopping.demo.constants.ShopExceptionCode;
import com.shopping.demo.dto.AddressDto;
import com.shopping.demo.entity.Address;
import com.shopping.demo.entity.User;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.repository.AddressRepository;
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
    AddressRepository addressRepository;

    @Override
    public void createAddress(AddressDto addressDto) {
        addressDto.setAddrUserId(((User) ThreadLocalUtils.get()).getId());
        addressRepository.save(new Address(addressDto));
    }

    @Override
    public List<Address> findAllAddress(Long UserId) {
        return addressRepository.findAddressesByAddrUserId(UserId);
    }

    @Override
    public Address findAddressById(Long id) {
        Address address = addressRepository.findAddressById(id);
        if(null == address){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"实体对象不存在");
        }
        return address;
    }

    @Override
    public Address editAddress(AddressDto addressDto) {
        Address address = findAddressById(addressDto.getId());

        address.setAddrUser(addressDto.getAddrUser());
        address.setAddrMobile(addressDto.getAddrMobile());
        address.setAddrProvince(addressDto.getAddrProvince());
        address.setAddrCity(addressDto.getAddrCity());
        address.setAddrCounty(addressDto.getAddrCounty());
        address.setAddrDetail(addressDto.getAddrDetail());

        return address;
    }

    @Override
    public void deleteAddress(AddressDto addressDto) {
        if(null != findAddressById(addressDto.getId())){
            addressRepository.delete(new Address(addressDto));
        }
    }


}
