package com.selftry.firsttry.service;

import com.selftry.firsttry.entity.Account;
import com.selftry.firsttry.entity.User;
import com.selftry.firsttry.mapper.AccountMapper;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    AccountMapper accountMapper;

    public Account findAccountByName(String userName) {
        Account account = accountMapper.findAccountByUsername(userName);
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User user = null;
        if (!StringUtils.isEmpty(userName)) {
            Account account = accountMapper.findAccountByUsername(userName);
            if (account != null) {
                List<GrantedAuthority> list = new ArrayList<>();
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + account.getRole());
                list.add(authority);
                user = new org.springframework.security.core.userdetails.User(account.getUsername(),
                        account.getPassword(), list);
            }
        }

        return user;
    }
}
