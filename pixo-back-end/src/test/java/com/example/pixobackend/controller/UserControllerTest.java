package com.example.pixobackend.controller;

import com.example.pixobackend.entity.User;
import com.example.pixobackend.service.UserService;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;
    @Autowired
    private MockMvc mockMvc;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this); //initilizes controller and mocks

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    public void should_return() throws Exception {
        when(userService.getUserById(1L)).thenReturn(new User());
        mockMvc.perform(get("/users/1")
             .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect((ResultMatcher) jsonPath("$.firstname").value("Veeresh"));
//        Mockito.when(userService.getUserById((long) 1)).thenReturn(new User(1,"Veeresh","Bahri","vrb","qwerty","vrb@gmail.com"));
//        //long id, String firstname, String lastname, String username, String password, String em
//        // Mockito.verify(userService, Mockito.times(2)).add(x, y);
//        assertThat(userController.getUserById((long)1).equals(new User(1,"Veeresh","Bahri","vrb","qwerty","vrb@gmail.com")));
    }
}


//
//    @MockBean
//    private UserService userService;
//
//    User mockuser = new User(1, "Veeresh", "Bahri", "vrb", "qwerty", "vrb@gmail.com");
//
//    @Test
//    public void retrieveDetailsForCourse() throws Exception {
//
//        //Mockito.when(
//        //userService.getUserById((long)1)).thenReturn(mockuser);
//        given(userService.getUserById(1L)).willReturn(mockuser);
//
////        mockMvc.perform(get("/users/1")
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk());
////                .andExpect((ResultMatcher) jsonPath("$.firstname").value("Veeresh"));
//    }
//}
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/user/1").accept(
//                MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        String expected = "{\"id\":1,\"firstname\":\"Veeresh\",\"lastname\":\"Bahri\",\"username\":\"vrb\",\"password\":\"qwerty\",\"email\":\"vrb@gmail.com\"}";
//
//	JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), true);
//    }
//}




