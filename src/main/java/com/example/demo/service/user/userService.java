package com.example.demo.service.user;

import com.example.demo.dal.user.model.User;

public interface userService {

    User info(String UserName, String UserPassword);

}
