package com.example.pixobackend.controller;

import com.example.pixobackend.entity.Login;
import com.example.pixobackend.entity.User;
import com.example.pixobackend.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@Api(value="User Controller",  description="Operations pertaining to user in pixogram")
public class UserController {

    @Autowired
    UserService userService;
    User checkUser;

    List<User> lu = new ArrayList<User>();
    @ApiOperation(value = "View a list of available Users", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(path = "/user")
    public ResponseEntity<Iterable<Login>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersList());
    }
    @ApiOperation(value = "get users by  Id", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(path = "/users/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Login>> getOtherUsers(@ApiParam(value = "User id from which User object will retrieve", required = true)
                                                             @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOtherUsers(userId));
    }

    @ApiOperation(value = "create an usedr")
    @PostMapping(path = "/user/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<User> createUser(@ApiParam(value = "User object store in database table", required = true)
                                                @RequestBody User user) {
        String checkUserName=user.getUsername();
        User checkUser=userService.findByUserName(checkUserName);
        if(checkUser==null){
            User _user = userService.createUser(user);
            Login login = new Login(user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getEmail());
            userService.createlogin(login);
            return ResponseEntity.status(HttpStatus.CREATED).body(_user);
        }
        else{
            return null;
        }


    }

    @ApiOperation(value = "get user by id")
    @GetMapping(path = "/user/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@ApiParam(value = "User id from which multiple Users object will retrieve", required = true)
                                                @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
    }

    @ApiOperation(value = "update user detail")
    @PutMapping(path = "/user/{userId}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void UpdateUser(@ApiParam(value = "Use User Id to update User object", required = true)
                               @PathVariable Long userId,@PathVariable String password) {
        userService.UpdateUser(userId, password);
    }

    @ApiOperation(value = "delete an user by id")
    @DeleteMapping(path="/user/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@ApiParam(value = "User Id from which User object will delete from database table", required = true)
                               @PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @ApiOperation(value = "get an user by name")
    @GetMapping(path="/user/findByUserName/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByName(@ApiParam(value = "User Name from which User object will retrieve", required = true)
                                                  @PathVariable String userName){
        User user=userService.findByUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
