package com.selftry.firsttry.mapper;

import com.selftry.firsttry.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findUserSelective(User user);

    int updateUserByPrimaryKey(User user);

    int addUser(User user);

    int deleteUserByPrimaryKey(Integer id);
}