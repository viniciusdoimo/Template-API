package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.DTO.RequestSaveTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestDeleteTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestUpdateDTO;
import com.viniciusdoimo.template.api.model.Table;
import com.viniciusdoimo.template.api.repositories.TabelaRepository;
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
public class TabelaService {
	
	@Autowired
	private TabelaRepository repository;
	
	public List<Table> buscarTabelas(){
		return repository.findAll();
	}

	public Table save(RequestSaveTabelaDTO request){
		if (request != null) {
			Table table = new Table(request.getMessage());
			return repository.save(table);
		}
		return  null;
	}

	public String updte(ResquestUpdateDTO request) {
		if(request != null){
//			Table table = new Table(request.getId());
			if(repository.update(request.getId(), request.getMessage()) == 1){
				return new String("Successful update");
			}
			return new String("update failed");
		}
		return null;
	}

	public void delete(ResquestDeleteTabelaDTO request) {
		if(request != null){
			Table table = new Table(request.getId());
			repository.delete(table);
		}
	}
}
