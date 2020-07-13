package com.example.pixobackend.service;

import com.example.pixobackend.entity.User;
import com.example.pixobackend.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User mockuser = new User(1, "Veeresh", "Bahri", "vrb", "qwerty", "vrb@gmail.com");

        Mockito.when(userRepository.userfindById(mockuser.getId()))
                .thenReturn(mockuser);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "Veeresh";
        User found = userService.getUserById(1L);

        Assert.assertEquals(found.getFirstname(),name);
    }
}