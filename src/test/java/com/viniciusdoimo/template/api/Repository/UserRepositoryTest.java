package com.viniciusdoimo.template.api.Repository;

import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.repositories.UserRepository;
import com.viniciusdoimo.template.api.utils.PasswordUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    private static final String URL = "/user";
    private static final Long ID = 1L;
    private static final String NAME = "Vinicius";
    private static final String SURNAME = "Doimo";
    private static final String EMAIL = "vinicius.rodrigues.doimo@gmail.com";
    private static final String CPF = "123.456.789-10";
    private static final String PASSWORD = "12345678";

    @Autowired
    UserRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAllInBatch();
        this.user = repository.save(
                new User(NAME, SURNAME, EMAIL, CPF, PASSWORD,new Date(),new Date())
        );
    }

    @Test
    public void testSave() {
        User persistenceResponse = repository.save(
                new User(NAME, SURNAME, EMAIL, CPF, PASSWORD, new Date(), new Date())
        );
        assertNotNull(persistenceResponse);
    }

    @Test
    public void testfindById() {
        assertEquals(this.user, repository.findById(this.user.getId()).get());
    }

    @Test
    public void testUpdate() {
        Optional<User> userOptional = repository.findById(this.user.getId());
        assertEquals(this.user, userOptional.get());
        User user = userOptional.get();
        user.setSurname("Rodrigues Doimo");
        repository.save(user);
        assertEquals(user.getSurname(), repository.findById(this.user.getId()).get().getSurname());
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
