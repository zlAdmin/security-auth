package com.zl.security.browser;

import com.zl.security.core.properties.ZlSecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录处理
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 20:56
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@RestController
public class BrowserSecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private ZlSecurityProperties ZLSecurityProperties;

    /**
     * 当需要身份认证的时候，跳转到这里
     * @return
     */
    @RequestMapping(value = "/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public String requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();  // 引发跳转的请求
            if (StringUtils.endsWithIgnoreCase(targetUrl, "html")) {
                redirectStrategy.sendRedirect(request, response, ZLSecurityProperties.getBrowser().getLoginPage());
            }
        }

        return "访问的服务需要身份认证，请引导用户到登录页";
    }
}
