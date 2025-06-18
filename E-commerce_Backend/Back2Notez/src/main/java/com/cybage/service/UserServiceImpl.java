package com.cybage.service;
import com.cybage.bean.UserBean;
import com.cybage.dao.UserDao;
import com.cybage.entity.UserEntity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ModelMapper modelMapper;
    
    //register
    @Override
    public String registerUser(UserBean userBean) {
    	if (userDao.findByEmail(userBean.getEmail()).isPresent()) {
    		throw new RuntimeException("Email already exists");
    	}
    	UserEntity userEntity = modelMapper.map(userBean, UserEntity.class);
    	userDao.save(userEntity);
		return "User Registered successfully";
    }
    
    //login
    @Override 
    public boolean loginUser(String email, String password) {
    	Optional<UserEntity> userExist = userDao.findByEmail(email);
		return userExist.map(user -> user.getPassword().equals(password)).orElse(false);
    	
    }
    
    //getAllUsers
    @Override
    public List<UserBean> getAllUsers() {
        return userDao.findAll()
                .stream()
                .map(this::convertToBean)
                .collect(Collectors.toList());
    }


    //getUserById
    @Override
    public UserBean getUserById(int userId) {
        Optional<UserEntity> optional = userDao.findById(userId);
        if (optional.isPresent()) {
            return convertToBean(optional.get());
        } else {
            throw new RuntimeException("User with ID " + userId + " not found");
        }
    }

    //updateUser
    @Override
    public UserBean updateUser(UserBean userBean) {
        if (userDao.existsById(userBean.getUserId())) {
            UserEntity updated = userDao.save(convertToEntity(userBean));
            return convertToBean(updated);
        }
        throw new RuntimeException("User not found for update");
    }
    
    //deleteUser
    @Override
    public boolean deleteUser(int userId) {
        if (userDao.existsById(userId)) {
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }
    
    //convertToEntity
    private UserEntity convertToEntity(UserBean bean) {
    	if(bean == null) {
    		throw new IllegalArgumentException("OrderBean is null");
    	}
    	return modelMapper.map(bean, UserEntity.class);
    }

    //convertToBean
    private UserBean convertToBean(UserEntity entity) {
    	if (entity==null) {
    		 throw new IllegalArgumentException("OrderEntity is null");
        }
        return modelMapper.map(entity, UserBean.class);
    }

}
