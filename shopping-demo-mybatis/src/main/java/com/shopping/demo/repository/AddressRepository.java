package com.shopping.demo.repository;

import com.shopping.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findAddressById(Long AddrId);

    List<Address> findAddressesByAddrUserId(Long userId);
}
