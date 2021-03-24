package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.dao.UserDAO;
import com.viniciusdoimo.template.api.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

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

//    @Autowired
//    UserService service;

    @BeforeEach
    void setUp() {
        BDDMockito.given(dao.create(Mockito.any(User.class))).willReturn(new User(ID, NAME, SURNAME, EMAIL, CPF, PASSWORD, new Date(), new Date()));

    }

    void testCreateUser() {
        Mockito.when(dao.create(Mockito.any(User.class))).thenReturn(getUserInstance());

        //Execução

        //Verificação

    }

//    @Test
//    void criarException() {
//        BDDMockito.given(dao.create(Mockito.any(User.class))).willReturn(new User(ID, NAME, SURNAME, EMAIL, CPF, PASSWORD, new Date(), new Date()));
//
//        User uder = dao.create(new User(null, NAME, SURNAME, EMAIL, CPF, PASSWORD, new Date(), new Date()));
//
//        assertThrows(Exception.class, ()-> dao.create(new User(null, NAME, SURNAME, EMAIL, CPF, PASSWORD, new Date(), new Date())));
//
//    }

    private User getUserInstance() {
        return new User(
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
