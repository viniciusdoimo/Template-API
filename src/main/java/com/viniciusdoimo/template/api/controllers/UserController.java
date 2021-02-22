package com.viniciusdoimo.template.api.controllers;

import com.viniciusdoimo.template.api.dto.request.RequestCreateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestDeleteUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestReadUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUpdateUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseCreateUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseDeleteUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseReadUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseUpdateUserDTO;
import com.viniciusdoimo.template.api.response.Response;
import com.viniciusdoimo.template.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<Response<ResponseCreateUserDTO>> createUserController(@Valid @RequestBody RequestCreateUserDTO request) {
		Response<ResponseCreateUserDTO> response;
			response = service.createUser(request);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<Response<ResponseReadUserDTO>> readUserController(@Valid @RequestBody RequestReadUserDTO request) throws Exception {
		Response<ResponseReadUserDTO> response = new Response<>();
			response = service.findById(request);
			return ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<Response<ResponseUpdateUserDTO>> updateUserController(@Valid @RequestBody RequestUpdateUserDTO request) throws Exception {
		Response<ResponseUpdateUserDTO> response = new Response<>();
			response = service.updateUser(request);
			return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping
	public ResponseEntity<Response<ResponseDeleteUserDTO>> deleteUserController(@Valid @RequestBody RequestDeleteUserDTO request) throws Exception {
		Response<ResponseDeleteUserDTO> response = new Response<>();
			response = service.deleteUser(request);
			return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
