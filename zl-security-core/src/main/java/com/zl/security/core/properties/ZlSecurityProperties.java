package com.zl.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 属性文件
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 21:14
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@Component
@ConfigurationProperties(prefix = "zl.security")
public class ZlSecurityProperties {
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
