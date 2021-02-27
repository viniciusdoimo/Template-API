package com.viniciusdoimo.template.api;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@SpringBootTest
@ActiveProfiles("test")
public class helloWorldTest {

    @Test
    public void testHelloWord(){
        assertEquals(1,1);
    }
}
