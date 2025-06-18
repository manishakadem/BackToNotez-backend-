package com.cybage.service;

import java.util.List;

import com.cybage.bean.UserBean;

public interface UserService {
   
	String registerUser(UserBean userBean);
	boolean loginUser(String email, String password);
    List<UserBean> getAllUsers();
    UserBean getUserById(int userId);
    UserBean updateUser(UserBean userBean);
    boolean deleteUser(int userId);
	

}
