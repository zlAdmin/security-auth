package com.zl.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户查询
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 10:54
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
public class UserQueryCondition {

    @ApiModelProperty(value = "用户名")   // swagger 参数描述
    private String userName;

    private int  age;

    private int  ageTo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }
}
