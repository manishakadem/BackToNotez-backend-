package com.cybage.service;

import java.util.List;

import com.cybage.bean.UserBean;

public interface UserService {
    UserBean createUser(UserBean userBean);
    List<UserBean> getAllUsers();
    UserBean getUserById(int userId);
    UserBean updateUser(UserBean userBean);
    boolean deleteUser(int userId);

}
