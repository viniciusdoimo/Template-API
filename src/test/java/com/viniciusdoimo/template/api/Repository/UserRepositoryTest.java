package com.viniciusdoimo.template.api.Repository;

import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.repositories.UserRepository;
import com.viniciusdoimo.template.api.utils.PasswordUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class UserRepositoryTest {
    private static final Long ID = 1L;
    private static final String NAME = "Vinicius";
    private static final String SURNAME = "Doimo";
    private static final String EMAIL = "vinicius.rodrigues.doimo@gmail.com";
    private static final String CPF = "123.456.789-10";
    private static final String PASSWORD = "12345678";

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    UserRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAllInBatch();
    }

    @Test
    public void testSave() {
        User user = repository.save(getUserInstance());
        assertNotNull(user.getId());
    }

    @Test
    public void testSaveInvalid() {
        assertThrows (DataIntegrityViolationException.class,
                () -> repository.save(new User(ID, NAME, SURNAME, null, CPF, PASSWORD, new Date(), new Date())));
    }

    @Test
    public void testfindById() {
        User user = entityManager.persist(getUserInstance());
        assertNotNull(repository.findById(user.getId()).get().getId());
    }

    @Test
    public void testFindByIdNotFound() {
        assertFalse(repository.findById(ID).isPresent());
    }

    @Test
    public void testUpdate() {
        User userPersisted = entityManager.persist(getUserInstance());
        Optional<User> userOptional = repository.findById(userPersisted.getId());
        assertTrue(userOptional.isPresent());
        User user = userOptional.get();

        user.setSurname("Rodrigues Doimo");
        repository.save(user);

        assertNotNull(user.getId());
    }

    @Test
    public void testUpdateInvalid() {
        Optional<User> userOptional = repository.findById(ID);
        assertFalse(userOptional.isPresent());
    }

    @Test
    public void testDelete() {
        User user = entityManager.persist(getUserInstance());
        assertNotNull(repository.findById(user.getId()).get().getId());
        repository.delete(user);
        assertFalse(repository.findById(user.getId()).isPresent());
    }

    @Test
    public void testExistsByCpf() {
        entityManager.persist(getUserInstance());
        assertTrue(repository.existsByCpf(CPF));
    }

    @Test
    public void testNotExistByCpf() {
        assertFalse(repository.existsByCpf(CPF));
    }

    private User getUserInstance(){
        return new User(
                NAME,
                SURNAME,
                EMAIL,
                CPF,
                PasswordUtils.generateBCrypt(PASSWORD),
                new Date(),
                new Date()
        );
    }
}
