package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.DTO.RequestSaveTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestDeleteTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestUpdateTabelaDTO;
import com.viniciusdoimo.template.api.model.Tabela;
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
	
	public List<Tabela> findTable(){
		return repository.findAll();
	}

	public Tabela save(RequestSaveTabelaDTO request){
		if (request != null) {
			Tabela tabela = new Tabela(request.getMessage());
			return repository.save(tabela);
		}
		return  null;
	}

	public String update(ResquestUpdateTabelaDTO request) {
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
			Tabela tabela = new Tabela(request.getId());
			repository.delete(tabela);
		}
	}
}
