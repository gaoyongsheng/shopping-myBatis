package com.shopping.demo.mapper;

import com.shopping.demo.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Gao
 * @Date 2021/1/31 16:33
 * @Version 1.0
 */

@Repository
public interface AddressMapper {

    // 新增收货地址
    Long insertAddress(Address address);

    // 修改收货地址
    boolean updateAddress(Address address);

    // 查找当前用户下的收货地址
    List<Address> getAddressByUserId(Long id);

    // 通过ID查找收货地址
    Address getAddressById(Long id);

    // 删除收货地址
    void deleteAddress(Long id);
}
