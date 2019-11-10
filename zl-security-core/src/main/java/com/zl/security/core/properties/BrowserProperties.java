package com.zl.security.core.properties;

/**
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 21:14
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
public class BrowserProperties {
    private String loginPage = "/zl-signIn.html";

    /**
     * 登录成功后的方式（跳转：REDIRECT，返回指定JSON: JSON）
     */
    private String loginType = "REDIRECT";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
