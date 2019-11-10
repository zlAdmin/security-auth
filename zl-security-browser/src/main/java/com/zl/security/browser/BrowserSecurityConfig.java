package com.zl.security.browser;

import com.zl.security.browser.com.zl.security.handler.AuthFailHandler;
import com.zl.security.browser.com.zl.security.handler.AuthSuccessHandler;
import com.zl.security.core.properties.ZlSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 浏览器端安全认证
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 17:30
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ZlSecurityProperties ZLSecurityProperties;
    @Autowired
    private AuthSuccessHandler successHandler;
    @Autowired
    private AuthFailHandler failHandler;

    /**
     * 密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* http.httpBasic(); // 默认没有form表单的校验 */
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(successHandler)
                .failureHandler(failHandler)
                .and()
                .authorizeRequests()   // 指接下来都是授权的配置
                .antMatchers("/authentication/require",
                        ZLSecurityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()  // 任何请求
                .authenticated()   // 都需要身份认证
                .and()
                .csrf().disable();  // 攻击防护关闭
    }
}
