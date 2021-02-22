package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @MockBean
    UserRepository repository;

    @Autowired
    UserService service;

    @BeforeEach
    void setUp() {
        BDDMockito.given(repository.findById(Mockito.anyLong())).willReturn(Optional.of(new User()));
    }

    //TODO: Criar testes para os outros métodos
//    @Test
//    public void testFindById(){
//        User user = service.findById(1L);
//        assertNotNull(user);
//    }

}
