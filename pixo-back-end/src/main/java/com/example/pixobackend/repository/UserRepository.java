package com.example.pixobackend.repository;

import com.example.pixobackend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userRepository")
public interface UserRepository  extends CrudRepository<User, Long> {

    @Query(value=" select f from User f where f.id=?1")
    public User userfindById( long fileId);

    @Transactional
    @Modifying
    @Query(value=" update User u set u.password=:pass where u.id=:id")
    public void UpdateUser(@Param(value="id")Long id, @Param(value="pass") String pass);

    @Query(value="select u from User u where u.username=?1")
    public User findByUserName(String userName);
}
