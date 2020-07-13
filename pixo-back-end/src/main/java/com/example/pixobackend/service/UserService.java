package com.example.pixobackend.service;

import com.example.pixobackend.entity.Login;
import com.example.pixobackend.entity.User;

import java.util.List;

public interface UserService {
    public Iterable<Login> getOtherUsers(Long id);

    public User createUser(User user);

    public User getUserById(Long userId);

    public Iterable<Login> getUsersList();

    public Login createlogin(Login log);

    public void UpdateUser(Long id, String pass);

    public void deleteUser(Long userId);

    public User findByUserName(String userName);
}
