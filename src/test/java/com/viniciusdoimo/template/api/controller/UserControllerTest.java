package com.viniciusdoimo.template.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viniciusdoimo.template.api.dto.request.RequestCreateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUpdateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUserByIdDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseToStringDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseUserDTO;
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
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {
    private static final String URL = "/user";
    private static final Long ID = 1L;
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
    public void testCreateUser() throws Exception {
        BDDMockito.given(service.createUser(Mockito.any(RequestCreateUserDTO.class))).willReturn(getResponseUserDTO());
        mvc.perform(MockMvcRequestBuilders.post(URL)
                .content(getJsonPayload(new RequestCreateUserDTO(NAME, SURNAME, EMAIL, CPF, PASSWORD)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.surname").value(SURNAME))
                .andExpect(jsonPath("$.data.email").value(EMAIL))
                .andExpect(jsonPath("$.data.cpf").value(CPF));
    }

    @Test
    public void tetsCreateUserInvalid() throws Exception {
        BDDMockito.given(service.createUser(Mockito.any(RequestCreateUserDTO.class))).willReturn(getResponseUserDTO());
        mvc.perform(MockMvcRequestBuilders.post(URL)
                .content(getJsonPayload(new RequestCreateUserDTO(NAME, SURNAME, "email", CPF, PASSWORD)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].message").value("email: must be a well-formed email address"));
    }

    @Test
    public void testReadUser() throws Exception {
        BDDMockito.given(service.findById(Mockito.any(RequestUserByIdDTO.class))).willReturn(getResponseUserDTO());
        mvc.perform(MockMvcRequestBuilders.get(URL)
                .content(getJsonPayload(new RequestUserByIdDTO(ID)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.surname").value(SURNAME))
                .andExpect(jsonPath("$.data.email").value(EMAIL))
                .andExpect(jsonPath("$.data.cpf").value(CPF));
    }

    @Test
    public void testReadUserInvalid() throws Exception {
        BDDMockito.given(service.findById(Mockito.any(RequestUserByIdDTO.class))).willReturn(getResponseUserDTO());
        mvc.perform(MockMvcRequestBuilders.get(URL)
                .content(getJsonPayload(new RequestUserByIdDTO()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].message").value("id: must not be null"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        BDDMockito.given(service.updateUser(Mockito.any(RequestUpdateUserDTO.class)))
                .willReturn(getResponseToStringDTO("User update successful"));

        RequestUpdateUserDTO request = new RequestUpdateUserDTO();
        request.setId(ID);
        request.setSurname("Rodrigues Doimo");

        mvc.perform(MockMvcRequestBuilders.put(URL)
                .content(getJsonPayload(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.answer").value("User update successful"));
    }

    @Test
    public void testUpdateUserInvalid() throws Exception {
        BDDMockito.given(service.updateUser(Mockito.any(RequestUpdateUserDTO.class)))
                .willReturn(getResponseToStringDTO("User update successful"));

        RequestUpdateUserDTO request = new RequestUpdateUserDTO();
        request.setSurname("Rodrigues Doimo");

        mvc.perform(MockMvcRequestBuilders.put(URL)
                .content(getJsonPayload(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].message").value("id: must not be null"));
    }

    @Test
    public void testDeleteUse() throws Exception {
        BDDMockito.given(service.deleteUser(Mockito.any(RequestUserByIdDTO.class)))
                .willReturn(getResponseToStringDTO("Successful user deletion"));
        mvc.perform(MockMvcRequestBuilders.delete(URL)
                .content(getJsonPayload(new RequestUserByIdDTO(ID)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.answer").value("Successful user deletion"));
    }

    @Test
    public void testDeleteUseInvalid() throws Exception {
        BDDMockito.given(service.deleteUser(Mockito.any(RequestUserByIdDTO.class)))
                .willReturn(getResponseToStringDTO("Successful user deletion"));
        mvc.perform(MockMvcRequestBuilders.delete(URL)
                .content(getJsonPayload(new RequestUserByIdDTO()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].message").value("id: must not be null"));
    }

    private Response<ResponseUserDTO> getResponseUserDTO() {
        Response<ResponseUserDTO> response = new Response<>();
        response.setData(
                new ResponseUserDTO(
                        new User(
                                NAME,
                                SURNAME,
                                EMAIL,
                                CPF,
                                PASSWORD,
                                new Date(),
                                new Date()
                        )
                )
        );
        return response;
    }

    private Response<ResponseToStringDTO> getResponseToStringDTO(String answer) {
        Response<ResponseToStringDTO> response = new Response<>();
        response.setData(new ResponseToStringDTO(answer));
        return response;
    }

    public String getJsonPayload(Object request) {
        try {
            return new ObjectMapper().writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
