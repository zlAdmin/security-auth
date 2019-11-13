package com.zl.security.browser;

import com.zl.security.browser.com.zl.security.handler.AuthFailHandler;
import com.zl.security.browser.com.zl.security.handler.AuthSuccessHandler;
import com.zl.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.zl.security.core.properties.ZlSecurityProperties;
import com.zl.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * 密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 配置记住我
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // tokenRepository.setCreateTableOnStartup(true);  创表语句，第一次执行打开
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* http.httpBasic(); // 默认没有form表单的校验 */
        // 在UsernamePasswordAuthenticationFilter前面加拦截器，可以进行登录验证码处理以及密码加解密处理
        /*http.addFilterBefore("自己的Filter", UsernamePasswordAuthenticationFilter.class)*/
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(successHandler)
                .failureHandler(failHandler)
                .and()
             .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(36000)
                .userDetailsService(userDetailsService)
                .and()
             .apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
             .authorizeRequests()   // 指接下来都是授权的配置
                .antMatchers("/authentication/require",
                        "/code/*",
                        ZLSecurityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()  // 任何请求
                .authenticated()   // 都需要身份认证
                .and()
                .csrf().disable();  // 攻击防护关闭
    }
}
