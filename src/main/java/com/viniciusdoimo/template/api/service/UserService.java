package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.dao.UserDAO;
import com.viniciusdoimo.template.api.dto.request.RequestCreateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestDeleteUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestReadUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUpdateUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseCreateUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseDeleteUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseReadUserDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseUpdateUserDTO;
import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.repositories.UserRepository;
import com.viniciusdoimo.template.api.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private UserDAO userDAO;

	public Response<ResponseCreateUserDTO> createUser(RequestCreateUserDTO request){
		Response<ResponseCreateUserDTO> response = new Response<>();
		User user = request.parseUser();
		response.setData(new ResponseCreateUserDTO(userDAO.create(user)));
		return response;
	}

	public Response<ResponseReadUserDTO> findById(RequestReadUserDTO request) throws Exception {
		Response<ResponseReadUserDTO> response = new Response<>();
		response.setData(new ResponseReadUserDTO(userDAO.findById(request.getId())));
		return response;
	}

	public Response<ResponseUpdateUserDTO> updateUser(RequestUpdateUserDTO request) throws Exception {
		Response<ResponseUpdateUserDTO> response = new Response<>();
		User user = request.parseUser(userDAO.findById(request.getId()));
		userDAO.update(user);
		response.setData(new ResponseUpdateUserDTO(user));
		return response;
	}

	public Response<ResponseDeleteUserDTO> deleteUser(RequestDeleteUserDTO request) throws Exception {
		Response<ResponseDeleteUserDTO> response = new Response<>();
		User user = userDAO.findById(request.getId());
		userDAO.delete(user);
		response.setData(new ResponseDeleteUserDTO("Successful user deletion"));
		return response;
	}
}
