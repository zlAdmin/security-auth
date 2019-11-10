package com.zl.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用户实体
 *
 *
 * jsonView的使用
 * 步骤1：使用接口来声明多个视图
 * 步骤2：在值对象的get方法上指定视图
 * 步骤3：在Controller方法上指定视图
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 10:40
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};


    private String id;

    private String userName;

    @NotBlank(message = "密码不能为空")
    private String  password;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
