package com.selftry.firsttry.mapper;

import com.selftry.firsttry.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    Account findAccountByUsername(String username);
}
