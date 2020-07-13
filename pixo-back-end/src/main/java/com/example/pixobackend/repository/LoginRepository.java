package com.example.pixobackend.repository;

import com.example.pixobackend.entity.Login;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {

    @Query(value="select l from Login l where l.id not in (select f.friend_id from Login l, Follow f where l.id=?1 and l.id=f.user_id) and l.id!=?1")
    public List<Login> getOtherUsers(long id);

    @Query(value=" select l from Login l where l.id in (select f.user_id from Login l, Follow f where l.id!=?1 and f.friend_id=?1 and f.block=0)")
    public List<Login> Followers(Long userId);

    @Query(value="select l from Login l where l.id in (select f.friend_id from Login l, Follow f where l.id=?1 and l.id=f.user_id )")
    public List<Login> Following(Long userId);

    @Query(value=" select f from Login f where f.id=?1")
    public Login userfindById(Long userId);

    @Transactional
    @Modifying
    @Query(value=" update Login l set l.password=:pass where l.id=:id")
    public void UpdateUser(@Param(value="id")Long id, @Param(value="pass") String pass);

    @Query(value="select l from Login l where l.id in(select f.user_id from Follow f where f.block=1 and f.friend_id=?1)")
    public List<Login> GetblockedUser(Long fid);

}