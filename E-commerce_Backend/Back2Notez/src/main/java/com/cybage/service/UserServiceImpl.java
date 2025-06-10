package com.cybage.service;
import com.cybage.bean.UserBean;
import com.cybage.dao.UserDao;
import com.cybage.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private UserBean toBean(UserEntity entity) {
        return new UserBean(
                entity.getUserId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getContact()
        );
    }

    private UserEntity toEntity(UserBean bean) {
        return new UserEntity(
                bean.getUserId(),
                bean.getName(),
                bean.getEmail(),
                bean.getPassword(),
                bean.getContact()
        );
    }

    @Override
    public UserBean createUser(UserBean userBean) {
        UserEntity entity = toEntity(userBean);
        UserEntity saved = userDao.save(entity);
        return toBean(saved);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return userDao.findAll().stream()
                .map(this::toBean)
                .collect(Collectors.toList());
    }

    @Override
    public UserBean getUserById(int userId) {
        Optional<UserEntity> optional = userDao.findById(userId);
        if (optional.isPresent()) {
            return toBean(optional.get());
        } else {
            System.out.println("User with ID " + userId + " not found");
            return null;
        }
    }

    @Override
    public UserBean updateUser(UserBean userBean) {
        if (userDao.existsById(userBean.getUserId())) {
            UserEntity updated = userDao.save(toEntity(userBean));
            return toBean(updated);
        }
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        if (userDao.existsById(userId)) {
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }

}
