package com.zl.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 用户校验
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 22:42
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: 2019/11/10 根据用户名从数据库获取用户的密码，进行校验
        String passwordInMysql = passwordEncoder.encode("123456");

        return new User(username,
                passwordInMysql,
                true,  // 是否可用
                true,  // 是否过期
                true,
                true,  // 是否锁定
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
