package com.viniciusdoimo.template.api.controllers;

import com.viniciusdoimo.template.api.model.Tabela;
import com.viniciusdoimo.template.api.service.TabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabela")
@CrossOrigin(origins = "*")
public class TabelaController {
	@Autowired
	private TabelaService service;
	
	@GetMapping
	public ResponseEntity<List<Tabela>> findAll() {
		List<Tabela> listTabela = service.buscarTabelas();
		return ResponseEntity.ok().body(listTabela);
	}
}
