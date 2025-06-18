package com.cybage.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.*;
import com.cybage.entity.AddressEntity;
import com.cybage.bean.*;
import com.cybage.entity.*;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AddressBean addAddress(AddressBean addressBean) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity = convertToEntity(addressBean);
		Optional<UserEntity> userOpt = userDao.findById(addressBean.getUser().getUserId());
		if (!userOpt.isPresent()) {
			throw new RuntimeException("User not found with ID: " + addressBean.getUser());
		}
		// addressEntity = modelMapper.map(addressBean, AddressEntity.class);
		AddressEntity savedEntity = addressDao.save(addressEntity);
		return convertToBean(savedEntity);
	}

	@Override
	public AddressBean getAddressById(int id) {
		AddressEntity addressEntity = addressDao.findById(id)
				.orElseThrow(() -> new RuntimeException("Address not found with ID: " + id));
		return convertToBean(addressEntity);
	}

	@Override
	public List<AddressBean> getAllAddresses() {
		return addressDao.findAll().stream().map(this::convertToBean).collect(Collectors.toList());
	}

	@Override
	public AddressBean updateAddress(int id, AddressBean addressBean) {
	    // Check if the address exists
	    AddressEntity existing = addressDao.findById(id)
	            .orElseThrow(() -> new RuntimeException("Address not found with ID: " + id));

	    AddressEntity updatedEntity = convertToEntity(addressBean);

	    // Ensure the correct ID is set for update
	    updatedEntity.setAddress_id(id);

	    if (updatedEntity.getUser() == null) {
	        updatedEntity.setUser(existing.getUser());
	    }

	    // Save and return updated bean
	    AddressEntity saved = addressDao.save(updatedEntity);
	    return convertToBean(saved);
	}


	@Override
	public void deleteAddress(int id) {
		AddressEntity existing = addressDao.findById(id)
				.orElseThrow(() -> new RuntimeException("Address not found with ID: " + id));
		addressDao.delete(existing);
	}

//coverting to entity using modelMapper
	private AddressEntity convertToEntity(AddressBean bean) {
		if (bean == null) {
			throw new IllegalArgumentException("AddressBean is null");
		}
		return modelMapper.map(bean, AddressEntity.class);
	}

	// coverting to bean using modelMapper
	public AddressBean convertToBean(AddressEntity entity) {
		if (entity == null) {
			throw new IllegalArgumentException("AddressEntity is null");
		}
		return modelMapper.map(entity, AddressBean.class);
	}
}
