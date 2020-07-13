package com.example.pixobackend.service;

import com.example.pixobackend.entity.Login;
import com.example.pixobackend.entity.User;
import com.example.pixobackend.repository.LoginRepository;
import com.example.pixobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginRepository loginRepository;

    @Override
    public Iterable<Login> getOtherUsers(Long Id) {
        return (List<Login>) loginRepository.getOtherUsers(Id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.userfindById(userId);
    }

    @Override
    public Iterable<Login> getUsersList() {
        return loginRepository.findAll();
    }


    @Override
    public Login createlogin(Login log) {
        // TODO Auto-generated method stub
        return loginRepository.save(log);
    }

    @Override
    public void UpdateUser(Long id, String pass) {
        loginRepository.UpdateUser(id, pass);
        userRepository.UpdateUser(id, pass);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        loginRepository.deleteById(userId);

    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}