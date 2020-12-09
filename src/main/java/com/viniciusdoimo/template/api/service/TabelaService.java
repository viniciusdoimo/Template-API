package com.viniciusdoimo.template.api.service;

import com.viniciusdoimo.template.api.model.Tabela;
import com.viniciusdoimo.template.api.repositories.TabelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelaService {
	
	@Autowired
	private TabelaRepository repository;
	
	public List<Tabela> buscarTabelas(){
		return repository.findAll();
	}
}
