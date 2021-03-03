package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.dao.UserDAO;
import com.viniciusdoimo.template.api.dto.request.RequestCreateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUpdateUserDTO;
import com.viniciusdoimo.template.api.dto.request.RequestUserByIdDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseToStringDTO;
import com.viniciusdoimo.template.api.dto.response.ResponseUserDTO;
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

	public Response<ResponseUserDTO> createUser(RequestCreateUserDTO request){
		Response<ResponseUserDTO> response = new Response<>();
		User user = request.parseUser();
		response.setData(new ResponseUserDTO(userDAO.create(user)));
		return response;
	}

	public Response<ResponseUserDTO> findById(RequestUserByIdDTO request) throws Exception {
		Response<ResponseUserDTO> response = new Response<>();
		response.setData(new ResponseUserDTO(userDAO.findById(request.getId())));
		return response;
	}

	public Response<ResponseToStringDTO> updateUser(RequestUpdateUserDTO request) throws Exception {
		Response<ResponseToStringDTO> response = new Response<>();
		User user = request.parseUser(userDAO.findById(request.getId()));
		userDAO.update(user);
		response.setData(new ResponseToStringDTO("User update successful"));
		return response;
	}

	public Response<ResponseToStringDTO> deleteUser(RequestUserByIdDTO request) throws Exception {
		Response<ResponseToStringDTO> response = new Response<>();
		User user = userDAO.findById(request.getId());
		userDAO.delete(user);
		response.setData(new ResponseToStringDTO("Successful user deletion"));
		return response;
	}
}
