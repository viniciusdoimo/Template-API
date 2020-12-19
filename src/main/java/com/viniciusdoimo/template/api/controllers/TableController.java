package com.viniciusdoimo.template.api.controllers;

import com.viniciusdoimo.template.api.DTO.RequestSaveTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestDeleteTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestUpdateTabelaDTO;
import com.viniciusdoimo.template.api.model.Tabela;
import com.viniciusdoimo.template.api.service.TabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@RestController
@RequestMapping("/table")
@CrossOrigin(origins = "*")
public class TableController {
	@Autowired
	private TabelaService service;
	
	@GetMapping
	public ResponseEntity<List<Tabela>> findAll() {
		List<Tabela> listTabela = service.findTable();
		return ResponseEntity.ok().body(listTabela);
	}

	@PostMapping
	public ResponseEntity<Tabela> save(@RequestBody RequestSaveTabelaDTO resquest){
		Tabela tabela = service.save(resquest);
		return ResponseEntity.ok().body(tabela);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody ResquestUpdateTabelaDTO request){
		String response = service.update(request);
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody ResquestDeleteTabelaDTO request){
		service.delete(request);
		return ResponseEntity.ok().body("Successful deletion");
	}
}
