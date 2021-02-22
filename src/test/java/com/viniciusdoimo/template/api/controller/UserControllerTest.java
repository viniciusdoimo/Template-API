package com.viniciusdoimo.template.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viniciusdoimo.template.api.dto.request.RequestCreateUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseCreateUserDTO;
import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.response.Response;
import com.viniciusdoimo.template.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {
    private static final String URL = "/user";
    private static final String NAME = "Vinicius";
    private static final String SURNAME = "Doimo";
    private static final String EMAIL = "vinicius.rodrigues.doimo@gmail.com";
    private static final String CPF = "123.456.789-10";
    private static final String PASSWORD = "12345678";

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    @Test
    public void testSave() throws Exception {
        BDDMockito.given(service.createUser(Mockito.any(RequestCreateUserDTO.class))).willReturn(getMockResponse());
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(NAME, SURNAME, EMAIL, CPF, PASSWORD))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.surname").value(SURNAME))
                .andExpect(jsonPath("$.data.email").value(EMAIL))
                .andExpect(jsonPath("$.data.cpf").value(CPF))
                .andExpect(jsonPath("$.data.password").doesNotExist());
    }

    @Test
    public void testSaveInvalidUser() throws Exception {
        BDDMockito.given(service.createUser(Mockito.any(RequestCreateUserDTO.class))).willReturn(getMockResponse());
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(NAME, SURNAME, "email", CPF, PASSWORD))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.[*].message").value("email: must be a well-formed email address"));
    }

    private User getMockUser(){
        return  new User(
                "Vinicius",
                "Doimo",
                "vinicius.rodrigues.doimo@gmail.com",
                "123.456.789-10",
                "12345678",
                new Date(),
                new Date()
        );
    }

    private Response<ResponseCreateUserDTO> getMockResponse(){
        Response<ResponseCreateUserDTO> response = new Response<>();
        response.setData(new ResponseCreateUserDTO(getMockUser()));
        return response;
    }

    private RequestCreateUserDTO getMockRequestCreateUserDTO(){
        return  new RequestCreateUserDTO(
                "Vinicius",
                "Doimo",
                "vinicius.rodrigues.doimo@gmail.com",
                "123.456.789-10",
                "12345678"
        );
    }

    public String getJsonPayload(String name, String surname, String email, String cpf, String password){
        RequestCreateUserDTO request = new RequestCreateUserDTO(name, surname, email, cpf, password);
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = null;

        try {
            jsonRequest = mapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonRequest;
    }

//    private RequestSaveUserDTO getMockTabela(){
//        return new RequestSaveUserDTO(
//                "Vinicius",
//                "Doimo",
//                "vinicius.rodrigues.doimo@gmail.com",
//                "123.456.789-10",
//                "12345678"
//        );
//    }

}
