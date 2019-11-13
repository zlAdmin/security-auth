package com.zl.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * 验证码基类
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-12 22:58
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
public class ValidateCode {
    /**
     * 验证码值
     */
    private String code;

    /**
     * 验证码超时时间
     */
    private LocalDateTime expireTime;

    /**
     * 以秒为单位设置过期时间
     * @param code
     * @param expireIn
     */
    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     * 设置过期时间
     * @param code
     * @param expireTime
     */
    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 是否过期
     * @return
     */
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
