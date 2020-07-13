package com.example.pixobackend.service;

import com.example.pixobackend.entity.Media;
import com.example.pixobackend.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MediaServiceImpl implements MediaService {
    private MediaRepository mediaRepository;
    @Autowired
    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public Media save(Media dbFile)  {
        return mediaRepository.save(dbFile);
    }

    @Override
    public ArrayList<Media> findByUserId(long userId) {
        return mediaRepository.findByUserId(userId);
    }
}

