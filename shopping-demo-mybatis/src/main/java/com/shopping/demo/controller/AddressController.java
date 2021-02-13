package com.shopping.demo.controller;

import com.shopping.demo.cro.AddressCro;
import com.shopping.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ldc
 * @Date 2020/12/2 11:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/service/v1")
public class AddressController extends AbstractBaseCtrl {

    @Autowired
    AddressService addressService;

    @PostMapping("/address.add")
    public Object createAddress(@RequestBody AddressCro addressCro){
        addressService.createAddress(addressCro.toDto());
        return success("");
    }

    @GetMapping("/address.findAllByUserId/{userId}")
    public Object findAll(@PathVariable("userId") Long userId){
        return success(addressService.findAllAddress(userId));
    }

    @GetMapping("/address.delete")
    public Object deleteAddress(@RequestParam("id") Long id){
        addressService.deleteAddress(id);
        return success("");
    }

    @PostMapping("/address.edit")
    public Object editAddress(@RequestBody AddressCro addressCro){

        return success(addressService.editAddress(addressCro.toDto()));

    }
}
