package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.dao.UserDAO;
import com.viniciusdoimo.template.api.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {
    private static final Long ID = 1L;
    private static final String NAME = "Vinicius";
    private static final String SURNAME = "Doimo";
    private static final String EMAIL = "vinicius.rodrigues.doimo@gmail.com";
    private static final String CPF = "123.456.789-10";
    private static final String PASSWORD = "12345678";

    @MockBean
    UserDAO dao;

    @Test
    void testCreateUser() {
        BDDMockito.given(dao.create(Mockito.any(User.class))).willReturn(getUserInstance());
        assertEquals(ID, dao.create(new User(ID, NAME, SURNAME, EMAIL, CPF, PASSWORD, new Date(), new Date())).getId());
    }

    @Test
    void testFindById() throws Exception {
        BDDMockito.given(dao.findById(ID)).willReturn(getUserInstance());
        assertEquals(ID, dao.findById(ID).getId());
    }

    @Test
    void testUpdateUser() throws Exception {
        BDDMockito.given(dao.findById(ID)).willReturn(getUserInstance());
        assertEquals(ID, dao.findById(ID).getId());
        dao.update(new User(ID, NAME, "Rodrigues Doimo", EMAIL, CPF, PASSWORD, new Date(), new Date()));
        BDDMockito.given(dao.findById(ID)).willReturn(new User(ID, NAME, "Rodrigues Doimo", EMAIL, CPF, PASSWORD, new Date(), new Date()));
        assertEquals("Rodrigues Doimo", dao.findById(ID).getSurname());
    }

    @Test
    void testDeleteUser() throws Exception {
        BDDMockito.given(dao.findById(ID)).willReturn(getUserInstance());
        assertEquals(ID, dao.findById(ID).getId());
        dao.delete(new User(ID, NAME, SURNAME, EMAIL, CPF, PASSWORD, new Date(), new Date()));
        BDDMockito.given(dao.findById(ID)).willReturn(null);
        assertNull(dao.findById(ID));
    }

    private static User getUserInstance() {
        return new User(
                ID,
                NAME,
                SURNAME,
                EMAIL,
                CPF,
                PASSWORD,
                new Date(),
                new Date()
        );
    }
}
