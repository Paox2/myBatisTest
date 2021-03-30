package com.selftry.firsttry.service;

import com.selftry.firsttry.entity.User;
import com.selftry.firsttry.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUsers() {
        List<User> userList = userMapper.findUserSelective(new User(null, null, null));
        return userList;
    }

    public List<User> findUserByName(String userName) {
        List<User> userList = userMapper.findUserSelective(new User(userName, null, null));
        return userList;
    }

    public List<User> findUserByAge(Integer userAge) {
        List<User> userList = userMapper.findUserSelective(new User(null, userAge, null));
        return userList;
    }

    public User findUserById(Integer userId) {
        List<User> userList = userMapper.findUserSelective(new User(null, null, userId));

        try {;
            if (userList.size() > 1)
                throw new Exception("Duplicate Unique Key");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userList.size() == 0)
            return null;
        else
            return userList.get(0);
    }

    public String updateUser(User user) {
        int i = userMapper.updateUserByPrimaryKey(user);
        return i == 1 ? "success" : "fail";
    }

    public String addUser(User user) {
        int i = userMapper.addUser(user);
        return i == 1 ? "success" : "fail";
    }

    public String deleteUserById(Integer userId) {
        int i = userMapper.deleteUserByPrimaryKey(userId);
        return i == 1 ? "success" : "fail";
    }
}