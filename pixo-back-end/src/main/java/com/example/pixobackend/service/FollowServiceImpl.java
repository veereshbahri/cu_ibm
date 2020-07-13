package com.example.pixobackend.service;

import com.example.pixobackend.entity.Follow;
import com.example.pixobackend.entity.Login;
import com.example.pixobackend.repository.FollowRepository;
import com.example.pixobackend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowRepository followRepository;

    @Autowired
    LoginRepository loginRepository;

    @Override
    public Follow follow(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public void unFollow(Long uid, Long Fid) {
        followRepository.deleteUnfollowById(uid, Fid);
        return;
    }

    @Override
    public Iterable<Login> followers(Long userId) {
        return loginRepository.Followers(userId);
    }

    @Override
    public Iterable<Login> following(Long userId) {
        return loginRepository.Following(userId);
    }

    @Override
    public void block(Long userId, Long friendId) {
        followRepository.Block(userId, friendId);
    }

    @Override
    public Iterable<Login> getBlockedUsers(Long fid) {
        return loginRepository.GetblockedUser(fid);
    }

    @Override
    public void unblock(Long userId, Long friendId) {
        followRepository.unBlock(userId, friendId);
    }
}
