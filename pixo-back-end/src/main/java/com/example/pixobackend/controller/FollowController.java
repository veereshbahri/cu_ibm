package com.example.pixobackend.controller;

import com.example.pixobackend.entity.Follow;
import com.example.pixobackend.entity.Login;
import com.example.pixobackend.service.FollowService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@Api(value="Follow Controller",  description="Operations pertaining to follow in pixogram")
public class FollowController {
    @Autowired
    FollowService followService;
    @ApiOperation(value = "follow another user")
    @GetMapping(path = "/follow/{userId}/{friendId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void Follow(@ApiParam(value = "User Id and Friend Id from which user follow friend", required = true)
                           @PathVariable Long userId, @PathVariable Long friendId) {
        Follow f=new Follow(userId,friendId,0);
        followService.follow(f);
    }
    @ApiOperation(value = "get followers by user id", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(path = "/followers/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Login>> Followers(@ApiParam(value = "User id from which Followers of user will retrieve", required = true)
                                                         @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(followService.followers(userId));
    }
    @ApiOperation(value = "get following by user id", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(path = "/following/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Login>> Following(@ApiParam(value = "User id from which Following of user will retrieve", required = true)
                                                         @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(followService.following(userId));
    }
    @ApiOperation(value = "Unfollow friend by user Id an friend Id")
    @DeleteMapping(path = "/follow/unfollow/{userId}/{friendId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void unfollow(@ApiParam(value = "User id and follower id from which User can unfollow friend", required = true)
                             @PathVariable Long userId,@PathVariable Long friendId) {
        followService.unFollow(userId, friendId);
    }

    @ApiOperation(value = "Block friend by user Id an friend Id")
    @PutMapping(path="/follow/block/{userId}/{friendId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void block(@ApiParam(value = "User Id and Follower Id from which user can Block friend", required = true)
                          @PathVariable Long userId,@PathVariable Long friendId) {
        followService.block(userId,friendId);
    }

    @ApiOperation(value = "Get Blocked Users", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(path = "/follow/getblockedusers/{friendId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Login>> getBlockedUsers(@ApiParam(value = "friend Id from which user will get blocked users", required = true)
                                                               @PathVariable Long friendId) {
        return ResponseEntity.status(HttpStatus.OK).body(followService.getBlockedUsers(friendId));
    }
    @ApiOperation(value = "Unbloclk friend")
    @PutMapping(path="/follow/unblock/{userId}/{friendId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void unblock(@ApiParam(value = "user Id and friend Id from which user can unblock friend")
@PathVariable Long userId,@PathVariable Long friendId) {
        followService.unblock(userId,friendId);
    }
}
