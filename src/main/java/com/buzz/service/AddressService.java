package com.buzz.service;

import com.buzz.dto.AddressResponse;
import com.buzz.dto.CreateAddressRequest;
import com.buzz.model.Address;
import com.buzz.repos.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    Logger logger = LoggerFactory.getLogger(AddressService.class);
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setStreet(createAddressRequest.getStreet());
        Address savedAddress = addressRepository.save(address);
        return new AddressResponse(savedAddress);
    }

    public AddressResponse getById(long id) {
        logger.info("AddressService provides:: getById with ID - {}", id);
        return new AddressResponse(addressRepository.findById(id).orElseThrow());
    }
}
