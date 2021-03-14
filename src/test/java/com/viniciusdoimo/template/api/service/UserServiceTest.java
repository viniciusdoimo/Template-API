package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.dao.UserDAO;
import com.viniciusdoimo.template.api.dto.request.RequestCreateUserDTO;
import com.viniciusdoimo.template.api.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    private static final Long ID = 1L;
    private static final String NAME = "Vinicius";
    private static final String SURNAME = "Doimo";
    private static final String EMAIL = "vinicius.rodrigues.doimo@gmail.com";
    private static final String CPF = "123.456.789-10";
    private static final String PASSWORD = "12345678";

    @MockBean
    UserDAO userDAO;
    @Autowired
    UserService service;

//    @MockBean
//    UserRepository repository;


//    @BeforeEach
//    void setUp() {
//        BDDMockito.given(repository.findById(Mockito.anyLong())).willReturn(Optional.of(new User()));
//    }

    @Test
    public void testeCreateUse() {
        BDDMockito.given(userDAO.create(Mockito.any(User.class))).willReturn(getUserInstance());
        assertNotNull(service.createUser(new RequestCreateUserDTO()));
    }



    private User getUserInstance() {
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
