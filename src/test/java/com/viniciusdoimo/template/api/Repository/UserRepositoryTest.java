package com.viniciusdoimo.template.api.Repository;

import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.repositories.UserRepository;
import com.viniciusdoimo.template.api.utils.PasswordUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
    private User user;

    @Autowired
    UserRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAllInBatch();
        this.user = repository.save(getUserInstance());
    }

    @Test
    public void testSave() {
        User persistenceResponse = repository.save(getUserInstance());
        assertNotNull(persistenceResponse);
    }

    @Test
    public void testfindById() {
        assertEquals(this.user, repository.findById(this.user.getId()).get());
    }

    @Test
    public void testUpdate() {
        assertEquals(this.user, repository.findById(this.user.getId()).get());
        user.setSurname("Rodrigues Doimo");
        repository.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void testDelete() {
        assertEquals(this.user, repository.findById(this.user.getId()).get());
        repository.delete(this.user);
        assertEquals(Optional.empty(), repository.findById(this.user.getId()));
    }

    private User getUserInstance(){
        return new User(
                "Vinicius",
                "Doimo",
                "vinicius.rodrigues.doimo@gmail.com",
                "123.456.789-10",
                PasswordUtils.generateBCrypt("12345678"),
                new Date(),
                new Date()
        );
    }
}
