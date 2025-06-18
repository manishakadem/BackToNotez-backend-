package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cybage.bean.AddressBean;
import com.cybage.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    
    @PostMapping("/add-address")
    public ResponseEntity<AddressBean> addAddress(@RequestBody AddressBean addressBean) {
        AddressBean saved = addressService.addAddress(addressBean);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/get-address/{id}")
    public ResponseEntity<AddressBean> getAddressById(@PathVariable int id) {
        AddressBean address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    
    @GetMapping("/get-all-addresses")
    public ResponseEntity<List<AddressBean>> getAllAddresses() {
        List<AddressBean> list = addressService.getAllAddresses();
        return ResponseEntity.ok(list);
    }

    // ✅ Update
    @PutMapping("/update-address/{id}")
    public ResponseEntity<AddressBean> updateAddress(@PathVariable int id, @RequestBody AddressBean addressBean) {
        AddressBean updated = addressService.updateAddress(id, addressBean);
        return ResponseEntity.ok(updated);
    }

    // ✅ Delete
    @DeleteMapping("/delete-address/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Address with ID " + id + " has been deleted.");
    }
}
