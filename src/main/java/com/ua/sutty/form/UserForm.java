package com.ua.sutty.form;

import com.ua.sutty.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {

    private String login;
    private String password;
    private Long roleId;

    public User toUser(){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRoleId(roleId);
        return user;
    }

}
