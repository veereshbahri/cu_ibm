package com.example.pixobackend.service;

import com.example.pixobackend.entity.Media;

import java.io.IOException;
import java.util.ArrayList;

public interface MediaService {
    Media save(Media dbFile) throws IOException;
    public ArrayList<Media> findByUserId(long fileId) throws IOException;
}
