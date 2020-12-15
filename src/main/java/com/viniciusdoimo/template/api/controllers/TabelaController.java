package com.viniciusdoimo.template.api.controllers;

import com.viniciusdoimo.template.api.DTO.RequestSaveTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestDeleteTabelaDTO;
import com.viniciusdoimo.template.api.DTO.ResquestUpdateDTO;
import com.viniciusdoimo.template.api.model.Table;
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
public class TabelaController {
	@Autowired
	private TabelaService service;
	
	@GetMapping
	public ResponseEntity<List<Table>> findAll() {
		List<Table> listTable = service.buscarTabelas();
		return ResponseEntity.ok().body(listTable);
	}

	@PostMapping
	public ResponseEntity<Table> save(@RequestBody RequestSaveTabelaDTO resquest){
		Table table = service.save(resquest);
		return ResponseEntity.ok().body(table);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody ResquestUpdateDTO request){
		String response = service.updte(request);
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody ResquestDeleteTabelaDTO request){
		service.delete(request);
		return ResponseEntity.ok().body("Successful deletion");
	}
}
