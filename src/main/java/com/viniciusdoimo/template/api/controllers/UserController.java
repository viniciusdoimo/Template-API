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
	public ResponseEntity<Response<ResponseUserDTO>> createUserController(@Valid @RequestBody RequestCreateUserDTO request) {
		Response<ResponseUserDTO> response;
			response = service.createUser(request);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<Response<ResponseUserDTO>> readUserController(@Valid @RequestBody RequestUserByIdDTO request) throws Exception {
		Response<ResponseUserDTO> response = new Response<>();
			response = service.findById(request);
			return ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<Response<ResponseToStringDTO>> updateUserController(@Valid @RequestBody RequestUpdateUserDTO request) throws Exception {
		Response<ResponseToStringDTO> response = new Response<>();
			response = service.updateUser(request);
			return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping
	public ResponseEntity<Response<ResponseToStringDTO>> deleteUserController(@Valid @RequestBody RequestUserByIdDTO request) throws Exception {
		Response<ResponseToStringDTO> response = new Response<>();
			response = service.deleteUser(request);
			return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
