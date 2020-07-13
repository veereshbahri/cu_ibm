package com.example.pixobackend.repository;

import com.example.pixobackend.entity.Media;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MediaRepository extends CrudRepository<Media, Long> {

    Media save(Media dbFile);

    @Query(value = " select m from Media m where m.userId=?1")
    public ArrayList<Media> findByUserId(long fileId);
}