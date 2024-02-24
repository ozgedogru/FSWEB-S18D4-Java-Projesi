package com.workintech.sprint18d4.service;

import com.workintech.sprint18d4.entity.Address;
import com.workintech.sprint18d4.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        Address address = getAddressById(id);

        address.setStreet(addressDetails.getStreet());
        address.setCity(addressDetails.getCity());
        address.setCountry(addressDetails.getCountry());
        address.setDescription(addressDetails.getDescription());

        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}
