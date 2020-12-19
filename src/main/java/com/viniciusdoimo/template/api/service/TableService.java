package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.DTO.RequestSaveTableDTO;
import com.viniciusdoimo.template.api.DTO.ResquestDeleteTableDTO;
import com.viniciusdoimo.template.api.DTO.ResquestUpdateDTO;
import com.viniciusdoimo.template.api.model.ModelTabela;
import com.viniciusdoimo.template.api.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Service
public class TableService {
	
	@Autowired
	private TableRepository repository;
	
	public List<ModelTabela> findTable(){
		return repository.findAll();
	}

	public ModelTabela save(RequestSaveTableDTO request){
		if (request != null) {
			ModelTabela modelTabela = new ModelTabela(request.getMessage());
			return repository.save(modelTabela);
		}
		return  null;
	}

	public String update(ResquestUpdateDTO request) {
		if(request != null){
//			Table table = new Table(request.getId());
			if(repository.update(request.getId(), request.getMessage()) == 1){
				return new String("Successful update");
			}
			return new String("update failed");
		}
		return null;
	}

	public void delete(ResquestDeleteTableDTO request) {
		if(request != null){
			ModelTabela modelTabela = new ModelTabela(request.getId());
			repository.delete(modelTabela);
		}
	}
}
