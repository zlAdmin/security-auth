package com.zl.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.zl.dto.User;
import com.zl.dto.UserQueryCondition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 10:37
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserDetailView.class)
    @ApiOperation(value = "查询用户")   // swagger 接口描述
    public List<User> query(UserQueryCondition userQueryCondition) {
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {
        User user = new User();
        user.setUserName("tom");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult err) {
        if (err.hasErrors()) {
            err.getAllErrors().forEach(item -> System.out.println(item.getDefaultMessage()));
        }
        System.out.println(user.getUserName());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult err) {
        if (err.hasErrors()) {
            err.getAllErrors().forEach(error -> {
                /*FieldError fieldError = (FieldError) error;
                String message = fieldError.getField() + "" + error.getDefaultMessage();*/
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user.getUserName());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }
}
