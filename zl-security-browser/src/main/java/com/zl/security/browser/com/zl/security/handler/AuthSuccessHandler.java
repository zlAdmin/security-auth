package com.zl.security.browser.com.zl.security.handler;

import com.zl.security.core.properties.ZlSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 22:29
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ZlSecurityProperties ZLSecurityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功处理----------------");
        if ("JSON".equals(ZLSecurityProperties.getBrowser().getLoginType())) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            // 把authentication对象转成 json 格式 字符串 通过 response 以application/json;charset=UTF-8 格式写到响应里面去
            httpServletResponse.getWriter().write("登录成功");
        } else {
            // 父类的方法 就是 跳转

        }
    }
}
