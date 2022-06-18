package com.buzz.controller;

import com.buzz.dto.AddressResponse;
import com.buzz.dto.CreateAddressRequest;
import com.buzz.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/address")
public class AddressController {
    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id){
        return addressService.getById(id);
    }

}
