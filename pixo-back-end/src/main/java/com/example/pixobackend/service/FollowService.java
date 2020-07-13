package com.example.pixobackend.service;

import com.example.pixobackend.entity.Follow;
import com.example.pixobackend.entity.Login;

import java.util.List;

public interface FollowService {
    public Follow follow(Follow follow);

    public Iterable<Login> followers(Long userId);

    public Iterable<Login> following(Long userId);

    public void unFollow(Long uid,Long fid);

    public void block(Long userId, Long friendId);

    public Iterable<Login> getBlockedUsers(Long friendId);

    public void unblock(Long userId, Long friendId);
}
