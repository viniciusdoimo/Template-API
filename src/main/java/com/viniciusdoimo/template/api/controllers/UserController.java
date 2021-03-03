package com.viniciusdoimo.template.api.controllers;

import com.viniciusdoimo.template.api.dto.request.RequestCreateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUpdateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUserByIdDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseToStringDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseUserDTO;
import com.viniciusdoimo.template.api.response.Response;
import com.viniciusdoimo.template.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Response<ResponseUserDTO>> createUserController(@Valid @RequestBody RequestCreateUserDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(request));
    }

    @GetMapping
    public ResponseEntity<Response<ResponseUserDTO>> readUserController(@Valid @RequestBody RequestUserByIdDTO request) throws Exception {
        return ResponseEntity.ok(service.findById(request));
    }

    @PutMapping
    public ResponseEntity<Response<ResponseToStringDTO>> updateUserController(@Valid @RequestBody RequestUpdateUserDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(request));
    }

    @DeleteMapping
    public ResponseEntity<Response<ResponseToStringDTO>> deleteUserController(@Valid @RequestBody RequestUserByIdDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(request));
    }
}
