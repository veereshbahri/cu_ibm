package com.example.pixobackend.repository;

import com.example.pixobackend.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;


//    @Autowired
//    public UserRepositoryTest(TestEntityManager entityManager, UserRepository userRepository) {
//        this.entityManager = entityManager;
//        this.userRepository = userRepository;
//    }

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        String name = "Veeresh";
        User mockuser = new User(1, "Veeresh", "Bahri", "vrb", "qwerty", "vrb@gmail.com");
        entityManager.persist(mockuser);
        entityManager.flush();

        // when
        User found = userRepository.userfindById(mockuser.getId());

        // then
        Assert.assertNotNull(found);
        Assert.assertEquals(found.getFirstname(),name);

    }

}

